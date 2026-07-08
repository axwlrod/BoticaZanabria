package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Caja;
import java.math.BigDecimal;


public interface ICajaService {
    Caja abrirCaja(BigDecimal montoInicial);
    Caja cerrarCaja(Integer idCaja, BigDecimal montoFinal);
    BigDecimal realizarCorte(Integer idCaja);
}
