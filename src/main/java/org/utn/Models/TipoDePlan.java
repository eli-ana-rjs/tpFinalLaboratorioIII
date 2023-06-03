package org.utn.Models;

public enum TipoDePlan {

    GRATIS(0 , 1),
    DUO(549, 2),
    INDIVIDUAL(399, 1),
    FAMILIAR(649, 4);

    private int precio;
    private double cantidadDeUsuarios;

    TipoDePlan(int precio, double cantidadDeUsuarios){
        this.precio = precio;
        this.cantidadDeUsuarios = cantidadDeUsuarios;
    }

}
