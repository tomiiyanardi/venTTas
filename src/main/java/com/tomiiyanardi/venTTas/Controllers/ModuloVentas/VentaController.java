package com.tomiiyanardi.venTTas.Controllers.ModuloVentas;

import com.tomiiyanardi.venTTas.Controllers.BaseControllerImpl;
import com.tomiiyanardi.venTTas.DTOs.DemandaHistoricaRequest;
import com.tomiiyanardi.venTTas.DTOs.PrediccionDemandaRequest;
import com.tomiiyanardi.venTTas.DTOs.VentaRequestDTO;
import com.tomiiyanardi.venTTas.Entities.Venta;
import com.tomiiyanardi.venTTas.Services.ModuloVentas.VentaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ventas")
public class VentaController extends BaseControllerImpl<Venta, VentaServiceImpl> {

    @PostMapping("createVenta")
    public ResponseEntity<?> createVenta(@RequestBody VentaRequestDTO ventaRequestDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.createVenta(ventaRequestDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("createDemandaHistorica")
    public ResponseEntity<?> createDemandaHistorica(@RequestBody DemandaHistoricaRequest demandaHistoricaRequest){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.createDemandaHistorica(demandaHistoricaRequest));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("prediccionDemanda")
    public ResponseEntity<?> createDemandaHistorica(@RequestBody PrediccionDemandaRequest prediccionDemandaRequest){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getPrediccionDemanda(prediccionDemandaRequest));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
