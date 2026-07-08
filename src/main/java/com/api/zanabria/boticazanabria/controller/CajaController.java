package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.Caja;
import com.api.zanabria.boticazanabria.service.ICajaService;
import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cajas")
public class CajaController {
    private final ICajaService cajaService;

    public CajaController(ICajaService cajaService) {
        this.cajaService = cajaService;
    }
    @PostMapping("/abrir")
    public ResponseEntity<?> abrirCaja(@RequestParam BigDecimal montoInicial) {
        try {         
            Caja nuevaCaja = cajaService.abrirCaja(montoInicial);
            return new ResponseEntity<>(nuevaCaja, HttpStatus.CREATED);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/cerrar/{idCaja}")
    public ResponseEntity<?> cerrarCaja(@PathVariable Integer idCaja, @RequestParam BigDecimal montoFinal) {
        try {
            Caja cajaCerrada = cajaService.cerrarCaja(idCaja, montoFinal);
            return new ResponseEntity<>(cajaCerrada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/corte/{idCaja}")
    public ResponseEntity<?> realizarCorte(@PathVariable Integer idCaja) {
        try {
            BigDecimal corteActual = cajaService.realizarCorte(idCaja);
            return new ResponseEntity<>(corteActual, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}