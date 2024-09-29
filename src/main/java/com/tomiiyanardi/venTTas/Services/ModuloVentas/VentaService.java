package com.tomiiyanardi.venTTas.Services.ModuloVentas;

import com.tomiiyanardi.venTTas.DTOs.DemandaHistoricaRequest;
import com.tomiiyanardi.venTTas.DTOs.PrediccionDemandaRequest;
import com.tomiiyanardi.venTTas.DTOs.VentaRequestDTO;
import com.tomiiyanardi.venTTas.Entities.DemandaHistorica;
import com.tomiiyanardi.venTTas.Entities.Venta;
import com.tomiiyanardi.venTTas.Services.BaseService;

import java.util.Map;

public interface VentaService extends BaseService<Venta, Long> {

    public Venta createVenta(VentaRequestDTO ventaRequestDTO) throws Exception;

    public DemandaHistorica createDemandaHistorica(DemandaHistoricaRequest demandaHistoricaRequest) throws Exception;

    public Map<String, Double> getPrediccionDemanda(PrediccionDemandaRequest prediccionDemandaRequest) throws Exception;

}
