
package com.api.zanabria.boticazanabria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idProveedor;
    
    @Column(length=200, nullable = false)
    private String razonSocial;
    
    @Column(length=12, nullable=false)
    private String telefono;
    
    @Column(length=11, nullable=false, unique=true)
    private String ruc;
    
    @Column(nullable=false)
    private Boolean activo=true;
}
