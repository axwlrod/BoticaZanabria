package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Categoria;
import com.api.zanabria.boticazanabria.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service 
public class CategoriaServiceImpl implements ICategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository; 

    @Override
    public Categoria registrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria modificarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> listarActivos() {
        return categoriaRepository.findByActivoTrue();
    }
    
    
}
