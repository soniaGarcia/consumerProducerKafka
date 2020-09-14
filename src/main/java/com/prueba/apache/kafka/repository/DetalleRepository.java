package com.prueba.apache.kafka.repository;

import com.prueba.apache.kafka.model.Detalle;
import com.prueba.apache.kafka.model.QDetalle;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sonia.cabrera
 */
public interface DetalleRepository 
        extends CrudRepository<Detalle, String>,QuerydslPredicateExecutor<Detalle>, , QuerydslBinderCustomizer<QDetalle>{
    
    @Override
	default public void customize(QuerydslBindings bindings, QDetalle root) {

	}
}
