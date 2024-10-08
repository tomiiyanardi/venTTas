package com.tomiiyanardi.venTTas.DTOs;

import com.tomiiyanardi.venTTas.Enums.TipoPeriodo;
import com.tomiiyanardi.venTTas.Enums.TipoPrediccion;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PrediccionDemandaRequest {

    private int numeroPeriodos;
    private TipoPeriodo tipoPeriodo;
    private LocalDate fechaDesdePrediccion;
    private Long articuloId;
    private TipoPrediccion tipoPrediccion;
    private int cantidadPredicciones;

    //Buscar ventas que coincidan con el articulo proporcionado acá

}
