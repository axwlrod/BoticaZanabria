package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.DetalleVenta;
import com.api.zanabria.boticazanabria.model.Producto;
import com.api.zanabria.boticazanabria.model.Venta;
import com.api.zanabria.boticazanabria.repository.VentaRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServicelmpl implements IVentaService {

    @Autowired
    private VentaRepository ventaRepo;
    
    @Autowired
    private IProductoService productoService;

    @Override
    @Transactional 
    public Venta registrarVenta(Venta venta) {
        BigDecimal sumaSubtotales = BigDecimal.ZERO;
        BigDecimal descuento = (venta.getDescuento() == null) ? BigDecimal.ZERO : venta.getDescuento();

        venta.setFechaVenta(LocalDateTime.now());

        for (DetalleVenta detalle : venta.getDetalles()) {
            Producto prod = productoService.buscarPorId(detalle.getProducto().getIdProducto());

            BigDecimal precioActual = prod.getPrecio();
            detalle.setPrecioUnitario(precioActual);

            BigDecimal subtotalLinea = precioActual.multiply(BigDecimal.valueOf(detalle.getCantidad()));
            detalle.setSubtotal(subtotalLinea);

            sumaSubtotales = sumaSubtotales.add(subtotalLinea);

            detalle.setVenta(venta);
            productoService.actualizarStock(prod.getIdProducto(), -detalle.getCantidad());
        }
        BigDecimal totalFinal = sumaSubtotales.subtract(descuento);

        if (totalFinal.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Error: El descuento no puede ser mayor que el subtotal de la venta.");
        }

        venta.setSubtotal(sumaSubtotales);
        venta.setDescuento(descuento);
        venta.setTotal(totalFinal);

        return ventaRepo.save(venta);
    }
}
