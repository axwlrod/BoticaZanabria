package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.Proveedor;
import com.api.zanabria.boticazanabria.service.IProveedorService;
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
@RequestMapping("/api/proveedor")
public class ProveedorController {
    @Autowired
    private  IProveedorService proveedorService;
    
    @GetMapping
    public List<Proveedor> listarTodos() {
        return proveedorService.listarTodos();
    }
    
    @PostMapping
    public Proveedor registrar(@RequestBody Proveedor proveedor){
        return proveedorService.registrarProveedor(proveedor);
    }
    
    @PutMapping
    public Proveedor modificar(@RequestBody Proveedor proveedor){
        return proveedorService.modificarProveedor(proveedor);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
         proveedorService.eliminarProveedor(id);
    }
    
    @GetMapping("/buscar")
    public List<Proveedor> buscarPorRazonSocial(@RequestParam String razonSocial) {
        return proveedorService.buscarPorRazonSocial(razonSocial);
    }
}
