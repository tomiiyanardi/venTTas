package com.tomiiyanardi.venTTas.Controllers;

import com.tomiiyanardi.venTTas.DTOs.OrdenCompraDTO;
import com.tomiiyanardi.venTTas.Entities.OrdenCompra;
import com.tomiiyanardi.venTTas.Services.OrdenCompraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/OrdenCompra")

public class OrdenCompraController extends BaseControllerImpl<OrdenCompra, OrdenCompraServiceImpl>{

    @Autowired
    OrdenCompraServiceImpl ordenCompraService;

    @GetMapping("/getall")
    public ResponseEntity<?> mostrarOrdenesCompra(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.mostrarOrdenesCompra());
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> nuevaOrdenCompraArt(@RequestBody OrdenCompraDTO ordenCompraDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.newOrdenCompra(ordenCompraDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}