    package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Proveedor;
import com.api.zanabria.boticazanabria.repository.ProveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ProveedorServicelmpl implements IProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    @Override
    public Proveedor registrarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor modificarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminarProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor buscarPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proveedor> buscarPorRazonSocial(String razonSocial) {
        return proveedorRepository.findByRazonSocialContainingIgnoreCase(razonSocial);
    }
}
