package com.tomiiyanardi.venTTas.Controllers.ModuloArticulos;

import com.tomiiyanardi.venTTas.Controllers.BaseControllerImpl;
import com.tomiiyanardi.venTTas.Entities.Articulo;
import com.tomiiyanardi.venTTas.Services.ArticuloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulo")
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl> {

    @Autowired
    ArticuloServiceImpl articuloService;
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorNombre(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.buscar(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/getTiposInventario")
    public ResponseEntity<?> getTiposInventario(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getTiposInventario());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/getEstadoOrdenDeCompra")
    public ResponseEntity<?> getEstadoOrdenDeCompra(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getEstadoOrdenDeCompra());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}

