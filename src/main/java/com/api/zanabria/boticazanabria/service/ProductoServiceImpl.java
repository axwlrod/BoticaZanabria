package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Producto;
import com.api.zanabria.boticazanabria.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private ProductoRepository productoRepository; 
    @Override
    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }


    @Override
    public Producto buscarPorCodigoBarra(String codigoBarra) {
        return productoRepository.findByCodigoBarra(codigoBarra);
    }

    @Override
    @Transactional
    public void actualizarStock(Integer idProducto, int cantidad) {
        Producto producto= productoRepository.findById(idProducto).orElseThrow(()->new RuntimeException("Producto No encontrado"));
        
        producto.setStockActual(producto.getStockActual()+cantidad);
        productoRepository.save(producto);
    }
    
}
