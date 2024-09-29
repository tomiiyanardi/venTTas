package com.tomiiyanardi.venTTas.Services;

import com.tomiiyanardi.venTTas.DTOs.OrdenCompraDTO;
import com.tomiiyanardi.venTTas.Entities.OrdenCompra;
import java.util.List;

public interface OrdenCompraService extends BaseService<OrdenCompra,Long>{
    public OrdenCompra newOrdenCompra (OrdenCompraDTO ordenCompraDTO) throws Exception;
    public List<OrdenCompra> mostrarOrdenesCompra () throws Exception;
}
