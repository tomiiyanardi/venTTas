package com.tomiiyanardi.venTTas.DTOs;

import lombok.Getter;

import java.util.List;

@Getter
public class CrearProveedorRequest {

    String nombre;
    List<ArticuloCrearProveedorRequest> articulos;

}
