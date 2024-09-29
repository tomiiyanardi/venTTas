package com.tomiiyanardi.venTTas.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "proveedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Proveedor extends Base{
    @Column(name = "fecha_hora_baja")
    private Date fecha_hora_baja;

    @Column(name = "nombre")
    private String nombre;

    //@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    //private List<ProveedorArticulo> proveedorArticulo;

    /*
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<OrdenCompra> ordenesCompra;
 */
}