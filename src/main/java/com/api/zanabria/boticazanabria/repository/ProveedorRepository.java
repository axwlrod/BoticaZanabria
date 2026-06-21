
package com.api.zanabria.boticazanabria.repository;

import com.api.zanabria.boticazanabria.model.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    List<Proveedor> findByRazonSocialContainingIgnoreCase(String razonSocial);   
}
