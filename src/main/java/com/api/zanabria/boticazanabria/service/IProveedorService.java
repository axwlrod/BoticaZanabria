/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Proveedor;
import java.util.List;

public interface IProveedorService {
    Proveedor registrarProveedor(Proveedor proveedor);
    Proveedor modificarProveedor(Proveedor proveedor);
    void eliminarProveedor(Integer id);
    
    List<Proveedor> listarTodos();
    Proveedor buscarPorId(Integer id);
    
    List<Proveedor> buscarPorRazonSocial(String razonSocial);
}
