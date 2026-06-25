package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.dto.SaneamientoStockDTO;
import com.api.zanabria.boticazanabria.model.Producto;
import com.api.zanabria.boticazanabria.model.SaneamientoStock;
import com.api.zanabria.boticazanabria.repository.SaneamientoStockRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaneamientoStockServiceImpl implements ISaneamientoStockService {

    @Autowired
    private SaneamientoStockRepository repo;
    
    @Autowired
    private IProductoService productoService;

    @Transactional
    @Override
    public void registrarSaneamiento(SaneamientoStock saneamiento) {
        Producto prod = productoService.buscarPorId(saneamiento.getProducto().getIdProducto());

        int diferencia = saneamiento.getStockFisico() - prod.getStockActual();
        saneamiento.setDiferencia(diferencia);
        
        BigDecimal costoTotal = prod.getPrecio().multiply(BigDecimal.valueOf(Math.abs(diferencia)));
        saneamiento.setTotalCosto(costoTotal);

        productoService.corregirStock(prod.getIdProducto(), saneamiento.getStockFisico());
        
        repo.save(saneamiento);
    }

    @Override
    public List<SaneamientoStockDTO> listarTodos() {
        return repo.findAll().stream().map(s -> new SaneamientoStockDTO(
            s.getIdSaneamiento(),
            s.getProducto() != null ? s.getProducto().getNombre() : "Sin Producto",
            s.getProducto() != null ? s.getProducto().getActivo() : false,
            s.getDiferencia(),
            s.getTotalCosto(),
            s.getFechaAjuste()
        )).collect(Collectors.toList());
    }

    
}