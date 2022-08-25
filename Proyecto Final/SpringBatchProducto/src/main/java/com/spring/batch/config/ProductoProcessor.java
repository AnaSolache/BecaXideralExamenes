package com.spring.batch.config;

import org.springframework.batch.item.ItemProcessor;
import com.spring.batch.entity.Producto;

public class ProductoProcessor implements ItemProcessor<Producto,Producto> {

    @Override
    public Producto process(Producto producto) throws Exception {
    	return producto;
    }
}
