package com.tomiiyanardi.venTTas.Services;

import com.tomiiyanardi.venTTas.Entities.Articulo;
import com.tomiiyanardi.venTTas.Enums.EstadoOrden;
import com.tomiiyanardi.venTTas.Enums.ModeloInventario;

import java.util.List;

public interface ArticuloService {
    List<Articulo> buscar(String filtro) throws Exception;
    List<ModeloInventario> getTiposInventario() throws Exception;
    public List<EstadoOrden> getEstadoOrdenDeCompra() throws Exception;


}
