package com.api.zanabria.boticazanabria.repository;

import com.api.zanabria.boticazanabria.model.SaneamientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaneamientoStockRepository extends JpaRepository<SaneamientoStock, Integer>{
    
}
