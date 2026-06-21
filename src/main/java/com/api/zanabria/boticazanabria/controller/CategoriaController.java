package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.Categoria;
import com.api.zanabria.boticazanabria.service.ICategoriaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private  ICategoriaService categoriaService;
    
    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }
    
    @PostMapping
    public Categoria registrar(@RequestBody Categoria categoria){
        return categoriaService.registrarCategoria(categoria);
    }
    
    @PutMapping
    public Categoria modificar(@RequestBody Categoria categoria){
        return categoriaService.modificarCategoria(categoria);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        categoriaService.eliminarCategoria(id);
    }
    
    @GetMapping("/activas")
    public List<Categoria> listarActivos(){
     return categoriaService.listarActivos();
    }
}
