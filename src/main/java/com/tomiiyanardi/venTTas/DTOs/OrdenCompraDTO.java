package com.tomiiyanardi.venTTas.DTOs;

import lombok.Data;

@Data
public class OrdenCompraDTO {
    int cantidad;
    int demoraEstimada;
    Long proveedorId;
    Long articuloId;
}