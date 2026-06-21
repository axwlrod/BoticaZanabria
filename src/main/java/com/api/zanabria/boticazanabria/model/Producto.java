package com.api.zanabria.boticazanabria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    
    @Column(length=40 , unique=true, nullable = false)
    private String codigoBarra;
    
    @Column(length=255, nullable = false)
    private String nombre;
    
    @Column(length=255, nullable = false)
    private String laboratorio;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;
    
    @Column(nullable=false)
    private Integer stockActual;
    @Column(nullable=false)
    private Integer stockMinimo;
    
    @Column(nullable=false)
    private LocalDate fechaVencimiento;
    
    @Column(nullable=false)
    private Boolean activo=true;
    
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    
}
