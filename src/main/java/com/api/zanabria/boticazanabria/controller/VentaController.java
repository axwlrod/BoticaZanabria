package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.Venta;
import com.api.zanabria.boticazanabria.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas") 
public class VentaController {
    
    @Autowired
    private IVentaService ventaService;
    
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Venta venta) {
        try {
            ventaService.registrarVenta(venta);
            return new ResponseEntity<>(venta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar la venta: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}