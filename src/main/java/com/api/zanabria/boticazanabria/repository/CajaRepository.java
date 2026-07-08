
package com.api.zanabria.boticazanabria.repository;

import com.api.zanabria.boticazanabria.enums.EstadoCaja;
import com.api.zanabria.boticazanabria.model.Caja;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepository extends JpaRepository<Caja, Integer>{
   Optional<Caja> findByEstado(EstadoCaja estado);
}
