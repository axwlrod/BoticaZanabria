package com.api.zanabria.boticazanabria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaneamientoStockDTO {
    
    private Integer idSaneamiento;
    private String nombreProducto;
    private Boolean activo;
    private int diferencia;
    private BigDecimal totalCosto;
    private LocalDateTime fechaAjuste;
   
}
