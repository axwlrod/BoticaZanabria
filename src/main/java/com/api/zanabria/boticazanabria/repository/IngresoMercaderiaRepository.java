package com.api.zanabria.boticazanabria.repository;

import com.api.zanabria.boticazanabria.model.IngresoMercaderia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoMercaderiaRepository extends JpaRepository<IngresoMercaderia, Integer> {
    
}
