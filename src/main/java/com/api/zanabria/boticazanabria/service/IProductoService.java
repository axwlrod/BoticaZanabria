package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Producto;
import java.util.List;

public interface IProductoService {
    Producto registrarProducto(Producto producto);
    Producto modificarProducto(Producto producto);
    void eliminarProducto(Integer id);
    
    List<Producto> listarTodos();
    Producto buscarPorId(Integer id);
}
