package com.tomiiyanardi.venTTas.Services;

import com.tomiiyanardi.venTTas.DTOs.CrearProveedorArticuloDTO;
import com.tomiiyanardi.venTTas.DTOs.EditarProveedorArticuloDTO;
import com.tomiiyanardi.venTTas.Entities.Articulo;
import com.tomiiyanardi.venTTas.Entities.Proveedor;
import com.tomiiyanardi.venTTas.Entities.ProveedorArticulo;
import com.tomiiyanardi.venTTas.Repositories.ArticuloRepository;
import com.tomiiyanardi.venTTas.Repositories.BaseRepository;
import com.tomiiyanardi.venTTas.Repositories.ProveedorArticuloRepository;
import com.tomiiyanardi.venTTas.Repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProveedorArticuloServiceImpl extends BaseServiceImpl<ProveedorArticulo,Long> implements ProveedorArticuloService {
    public ProveedorArticuloServiceImpl(BaseRepository<ProveedorArticulo, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ArticuloRepository articuloRepository;
    @Autowired
    private ProveedorArticuloRepository proveedorArticuloRepository;

    @Override
    public ProveedorArticulo nuevoProveedorArticulo(CrearProveedorArticuloDTO crearProveedorArticuloDTO) throws Exception {
        ProveedorArticulo proveedorArticulo = new ProveedorArticulo();

        Optional<Articulo> articuloOptional = articuloRepository.findById(crearProveedorArticuloDTO.getArticuloId());
        if (!articuloOptional.isPresent()) {
            throw new Exception("Articulo no encontrado");
        }
        Articulo articulo = articuloOptional.get();

        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(crearProveedorArticuloDTO.getProveedorId());
        if (!proveedorOptional.isPresent()) {
            throw new Exception("Proveedor no encontrado");
        }
        Proveedor proveedor = proveedorOptional.get();

        proveedorArticulo.setArticulo(articulo);
        proveedorArticulo.setDemoraPromedio(crearProveedorArticuloDTO.getDemora());
        proveedorArticulo.setProveedor(proveedor);


        baseRepository.save(proveedorArticulo);
        return proveedorArticulo;
    }

    @Override
    public Optional<ProveedorArticulo> modificarDatosProveedorArticulo(Long id, EditarProveedorArticuloDTO editarProveedorArticuloDTO) throws Exception {
            Optional<ProveedorArticulo> proveedorArticuloOptional = proveedorArticuloRepository.findById(id);
            if (proveedorArticuloOptional.isEmpty()) {
                ProveedorArticulo proveedorArticulo = proveedorArticuloOptional.get();
                proveedorArticulo.setDemoraPromedio(editarProveedorArticuloDTO.getDemora());
                return Optional.ofNullable(proveedorArticuloRepository.save(proveedorArticulo));
            } else {
                throw new Exception("Proveedor-Articulo no encontrado");
            }

        }
    }