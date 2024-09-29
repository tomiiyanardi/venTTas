package com.tomiiyanardi.venTTas.Services;

import com.tomiiyanardi.venTTas.DTOs.CrearProveedorArticuloDTO;
import com.tomiiyanardi.venTTas.DTOs.EditarProveedorArticuloDTO;
import com.tomiiyanardi.venTTas.Entities.ProveedorArticulo;

import java.util.Optional;

public interface ProveedorArticuloService extends BaseService<ProveedorArticulo,Long>{
    public ProveedorArticulo nuevoProveedorArticulo(CrearProveedorArticuloDTO crearProveedorArticuloDTO) throws Exception;
    public Optional<ProveedorArticulo> modificarDatosProveedorArticulo(Long id, EditarProveedorArticuloDTO editarProveedorArticuloDTO) throws Exception;

}