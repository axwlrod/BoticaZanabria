package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.Producto;
import com.api.zanabria.boticazanabria.service.IProductoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private  IProductoService productoService;
    
    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.listarTodos();
    }
    
    @PostMapping
    public Producto registrar(@RequestBody Producto producto){
        return productoService.registrarProducto(producto);
    }
    
    @PutMapping
    public Producto modificar(@RequestBody Producto producto){
        return productoService.modificarProducto(producto);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
         productoService.eliminarProducto(id);
    }
    
    @GetMapping ("/buscar")
    public List<Producto> buscarPorNombre(@RequestParam String nombre){
        return productoService.buscarPorNombre(nombre);
    }
    
    @GetMapping("/codigo/{codigoBarra}")
    public Producto buscarPorCodigoBarra(@PathVariable String codigoBarra) {
        return productoService.buscarPorCodigoBarra(codigoBarra);
    }
}
