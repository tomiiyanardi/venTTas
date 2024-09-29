package com.tomiiyanardi.venTTas.Repositories;

import com.tomiiyanardi.venTTas.Entities.OrdenCompra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra, Long>{
    @Query(value = "SELECT oc FROM OrdenCompra oc WHERE oc.id = :id")
    OrdenCompra buscarPorId(@Param("id") Long id);
    @Query("SELECT oc FROM OrdenCompra oc ORDER BY oc.nroOrdenCompra DESC")
    Optional<OrdenCompra> findTopByOrderByNroOrdenCompraDesc();

}