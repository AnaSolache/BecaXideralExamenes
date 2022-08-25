package com.spring.batch.repository;

import com.spring.batch.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto,Integer> {
}
