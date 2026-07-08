package com.api.zanabria.boticazanabria.model;

import com.api.zanabria.boticazanabria.enums.EstadoCaja;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cajas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaja;
    
    @Column(nullable=false)
    private LocalDateTime fechaApertura;
    
    @Column
    private LocalDateTime fechaCierre;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal montoInicial;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal montoFinal;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private EstadoCaja estado;
}