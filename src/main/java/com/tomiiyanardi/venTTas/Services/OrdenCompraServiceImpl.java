package com.tomiiyanardi.venTTas.Services;

import com.tomiiyanardi.venTTas.DTOs.OrdenCompraDTO;
import com.tomiiyanardi.venTTas.Entities.Articulo;
import com.tomiiyanardi.venTTas.Entities.OrdenCompra;
import com.tomiiyanardi.venTTas.Entities.Proveedor;
import com.tomiiyanardi.venTTas.Repositories.ArticuloRepository;
import com.tomiiyanardi.venTTas.Repositories.BaseRepository;
import com.tomiiyanardi.venTTas.Repositories.OrdenCompraRepository;
import com.tomiiyanardi.venTTas.Repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.tomiiyanardi.venTTas.Enums.EstadoOrden.PENDIENTE;

@Service
public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra,Long> implements OrdenCompraService {
    @Autowired
    private OrdenCompraRepository ordencompraRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    public OrdenCompraServiceImpl(BaseRepository<OrdenCompra, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<OrdenCompra> mostrarOrdenesCompra () throws Exception{
        try {
            List<OrdenCompra> ordenCompras = ordencompraRepository.findAll();
            return ordenCompras;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public OrdenCompra newOrdenCompra(OrdenCompraDTO ordenCompraDTO) throws Exception {

        Optional<OrdenCompra> ultimaOrdenCompra = ordencompraRepository.findTopByOrderByNroOrdenCompraDesc();
        OrdenCompra ordenCompra = new OrdenCompra();

        if (ultimaOrdenCompra.isEmpty()){
            ordenCompra.setNroOrdenCompra(0);
        }

        else {
            int nummasaltoOC = ultimaOrdenCompra.get().getNroOrdenCompra();
            ordenCompra.setNroOrdenCompra(nummasaltoOC+1);
        }

        ordenCompra.setCantidad(ordenCompraDTO.getCantidad());
        ordenCompra.setDemoraEstimada(ordenCompraDTO.getDemoraEstimada());
        ordenCompra.setFechaHoraAlta(LocalDate.now());

        Optional<Proveedor> p1 =  proveedorRepository.findById(ordenCompraDTO.getProveedorId());

            Proveedor proveedor = p1.get();
            ordenCompra.setProveedor(proveedor);

        Optional<Articulo> a1 =  articuloRepository.findById(ordenCompraDTO.getArticuloId());

        Articulo articulo = a1.get();
        ordenCompra.setArticulo(articulo);

            if (p1.isPresent()) {
                System.out.println("Proveedor encontrado");
        }
            else {
                throw new Exception("No se encontró al proveedor");
            }

            if (a1.isPresent()){
            System.out.println("Articulo encontrado");
        }
            else {
                throw new Exception("No se enontró el articulo");
            }

        ordenCompra.setNombreEstado(PENDIENTE);

        return ordenCompra;
    }
}