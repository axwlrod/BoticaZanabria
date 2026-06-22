package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.IngresoMercaderia;
import com.api.zanabria.boticazanabria.service.IIngresoMercaderiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ingresos")
public class IngresoMercaderiaController {
    
    @Autowired
    IIngresoMercaderiaService ingresoService;
    
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody IngresoMercaderia ingreso){
        ingresoService.registrarIngreso(ingreso);
        return new ResponseEntity<>("Ingreso registrado correctamente", HttpStatus.CREATED);
    }
}
