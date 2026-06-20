package com.api.zanabria.boticazanabria.service;


import com.api.zanabria.boticazanabria.model.Categoria;
import java.util.List;

public interface ICategoriaService {
    Categoria registrarCategoria(Categoria categoria);
    Categoria modificarCategoria(Categoria producto);
    void eliminarCategoria(Integer id);
    
    List<Categoria> listarTodos();
    Categoria buscarPorId(Integer id);
}
