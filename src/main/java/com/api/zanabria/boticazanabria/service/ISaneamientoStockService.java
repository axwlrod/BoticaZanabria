package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.dto.SaneamientoStockDTO;
import com.api.zanabria.boticazanabria.model.SaneamientoStock;
import java.util.List;

public interface ISaneamientoStockService {
    void registrarSaneamiento(SaneamientoStock saneamiento);
     List<SaneamientoStockDTO> listarTodos(); 
}

