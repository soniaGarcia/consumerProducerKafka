package com.prueba.apache.kafka.helper;

import com.prueba.apache.kafka.mensajeDTO.VehiculoMsj;
import com.prueba.apache.kafka.model.Detalle;
import com.prueba.apache.kafka.repository.DetalleRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorKafka {

    @Autowired
    DetalleRepository detalleRepository;

    @Autowired
    private ProductorKafka productorKafka;

    @KafkaListener(topics = "detalle", groupId = "foo", containerFactory = "vehiculoKafkaListenerContainerFactory")
    public void listenTest(VehiculoMsj message) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        Detalle persisDetalle = new Detalle();
        persisDetalle.fechaRecepcion = date;
        persisDetalle.precio = message.precio;
        persisDetalle.idVehiculo = message.id;
        productorKafka.sendCustomMessage(message);
        detalleRepository.save(persisDetalle);

        System.out.println("Received Message in group foo: " + message.marca);
    }

}
