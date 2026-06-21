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
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column(length=30, nullable=false, unique=true)
    private String usuario;
    
    @Column(length=255, nullable=false)
    private String contrasena;
    
    @Column(nullable=false)
    private Boolean activo=true;
}
