package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.enums.EstadoCaja;
import com.api.zanabria.boticazanabria.model.Caja;
import com.api.zanabria.boticazanabria.repository.CajaRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service    
public class CajaServicelmpl implements ICajaService {

    private final CajaRepository cajaRepository;

    public CajaServicelmpl(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    @Override
    public Caja abrirCaja(BigDecimal montoInicial) {
        Optional<Caja> cajaAbierta = cajaRepository.findByEstado(EstadoCaja.ABIERTA);
        
        if (cajaAbierta.isPresent()) {
            throw new RuntimeException("Ya existe una caja abierta. Debe cerrarla antes de abrir una nueva.");
        }

            Caja nuevaCaja = new Caja();
        nuevaCaja.setMontoInicial(montoInicial);
        nuevaCaja.setFechaApertura(LocalDateTime.now());
        nuevaCaja.setEstado(EstadoCaja.ABIERTA);
        
        return cajaRepository.save(nuevaCaja);
    }

    @Override
    public Caja cerrarCaja(Integer idCaja, BigDecimal montoFinal) {
        Caja caja = cajaRepository.findById(idCaja)
                .orElseThrow(() -> new RuntimeException("Error: No se encontró ninguna caja con el ID " + idCaja));

        if (caja.getEstado() == EstadoCaja.CERRADA) {
            throw new RuntimeException("Error: La caja ya se encuentra cerrada.");
        }
        caja.setFechaCierre(LocalDateTime.now()); 
        caja.setMontoFinal(montoFinal);           
        caja.setEstado(EstadoCaja.CERRADA);      
        return cajaRepository.save(caja);
    }

    @Override
    public BigDecimal realizarCorte(Integer idCaja) {
        Caja caja = cajaRepository.findById(idCaja)
                .orElseThrow(() -> new RuntimeException("Error: No se encontró ninguna caja con el ID " + idCaja));
        
        BigDecimal montoInicial= caja.getMontoInicial();
        BigDecimal totalVentas = BigDecimal.ZERO; /// TODO: Conectar con VentaRepository para sumar ventas del turno.
      
        return montoInicial.add(totalVentas);
    }
}