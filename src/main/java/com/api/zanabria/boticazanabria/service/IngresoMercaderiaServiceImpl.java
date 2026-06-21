
package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.DetalleIngreso;
import com.api.zanabria.boticazanabria.model.IngresoMercaderia;
import com.api.zanabria.boticazanabria.repository.IngresoMercaderiaRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresoMercaderiaServiceImpl implements IIngresoMercaderiaService {
    
    @Autowired
    private IngresoMercaderiaRepository ingresoRepo;
    @Autowired
    private IProductoService productoService;
    
    @Override
    @Transactional 
    public void registrarIngreso(IngresoMercaderia ingreso) {
        BigDecimal totalFinal = BigDecimal.ZERO;

        for (DetalleIngreso detalle : ingreso.getDetalles()){
            BigDecimal subtotal = detalle.getCostoUnitario().multiply(BigDecimal.valueOf(detalle.getCantidad()));
            detalle.setSubtotal(subtotal);
            totalFinal = totalFinal.add(subtotal);

            detalle.setIngreso(ingreso);

            productoService.actualizarStock(detalle.getProducto().getIdProducto(), detalle.getCantidad());
        }

        ingreso.setTotalCosto(totalFinal);
        ingresoRepo.save(ingreso);
    }
}