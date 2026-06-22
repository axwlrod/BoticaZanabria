package com.api.zanabria.boticazanabria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="IngresoMercaderias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngresoMercaderia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idIngreso;
    
    @Column(nullable=false, length=12)
    private String nroFactura;
    
    @Column(nullable=false)
    private LocalDateTime fechaIngreso;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalCosto;
    
    @OneToMany(mappedBy = "ingreso", cascade= CascadeType.ALL)
    private List<DetalleIngreso> detalles;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
}
