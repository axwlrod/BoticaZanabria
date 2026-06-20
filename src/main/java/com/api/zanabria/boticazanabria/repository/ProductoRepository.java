package com.api.zanabria.boticazanabria.repository;

import com.api.zanabria.boticazanabria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
