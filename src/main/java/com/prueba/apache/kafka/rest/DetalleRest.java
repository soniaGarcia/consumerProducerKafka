package com.prueba.apache.kafka.rest;

import com.prueba.apache.kafka.model.Detalle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.apache.kafka.repository.DetalleRepository;

/**
 *
 * @author Sonia
 */
@RestController
@RequestMapping(value = "/detalle")
public class DetalleRest {

    @Autowired
    DetalleRepository detalleRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Detalle> getDetalle() {
        Iterable<Detalle> iterator = detalleRepository.findAll();
        List<Detalle> result = new ArrayList<>();
        iterator.forEach(result::add);
        return result;
    }

}
