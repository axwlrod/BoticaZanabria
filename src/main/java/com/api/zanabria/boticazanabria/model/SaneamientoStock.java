package com.api.zanabria.boticazanabria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="Saneamientos")
@AllArgsConstructor
@NoArgsConstructor
public class SaneamientoStock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSaneamiento;
    
    @Column(nullable=false)
    private int stockSistema;
    
    @Column(nullable=false)
    private int stockFisico;
    
    @Column(nullable=false)
    private int diferencia;
    
    @Column(nullable=false, length=255)
    private String motivo;
    
    @Column(nullable=false)
    private LocalDateTime fechaAjuste;
    
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalCosto;
    
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    @PrePersist
    protected void onCreate() {
        this.fechaAjuste = LocalDateTime.now();
    }
}
