package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.dto.SaneamientoStockDTO;
import com.api.zanabria.boticazanabria.model.SaneamientoStock;
import com.api.zanabria.boticazanabria.service.ISaneamientoStockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saneamientos")
public class SaneamientoStockController {

    @Autowired
    private ISaneamientoStockService service;

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody SaneamientoStock saneamiento) {
        service.registrarSaneamiento(saneamiento);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<SaneamientoStockDTO>> listar() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }
}