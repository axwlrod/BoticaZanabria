package com.api.zanabria.boticazanabria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="DetalleIngreso")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DetalleIngreso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal costoUnitario;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_ingreso")
    @ToString.Exclude
    private IngresoMercaderia ingreso;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
