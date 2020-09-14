package com.prueba.apache.kafka.model;

import com.google.gson.GsonBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author sonia.cabrera
 */
@Document(collection = "detalle")
public class Detalle {

    @Id
    public ObjectId id;

    public ObjectId idVehiculo;
    public Integer precio;
    public String fechaRecepcion;
    public String fechaVenta;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
