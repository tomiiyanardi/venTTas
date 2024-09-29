package com.tomiiyanardi.venTTas.Services;

import com.tomiiyanardi.venTTas.DTOs.EditarProveedorDTO;
import com.tomiiyanardi.venTTas.DTOs.CrearProveedorRequest;
import com.tomiiyanardi.venTTas.Entities.Proveedor;
import java.util.List;
import java.util.Optional;

public interface ProveedorService extends BaseService<Proveedor,Long>{

    List<Proveedor> buscarPorNombre(String filtroNombre) throws Exception;
    public List<Proveedor> mostrarProveedores() throws Exception;
    public Optional<Proveedor> modificarDatosProveedor(Long id, EditarProveedorDTO editarProveedorDTO) throws Exception;

    Proveedor crearProveedor(CrearProveedorRequest crearProveedorRequest) throws Exception;

}
