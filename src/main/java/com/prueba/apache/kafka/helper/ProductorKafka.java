package com.prueba.apache.kafka.helper;

import com.prueba.apache.kafka.mensajeDTO.VehiculoMsj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductorKafka {

    @Autowired
    private KafkaTemplate<String, VehiculoMsj> vehiculoKafkaTemplate;

    private final String kafkaTopic = "invent";
   
    /**
     *
     * @param vehiculo
     */
    public void sendCustomMessage(VehiculoMsj vehiculo) {
        vehiculoKafkaTemplate.send(kafkaTopic, vehiculo);
    }

}
