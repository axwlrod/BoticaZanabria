package com.api.zanabria.boticazanabria.repository;

import com.api.zanabria.boticazanabria.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    List<Categoria> findByActivoTrue();
}
