package org.utn.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Usuario implements Serializable {

    //region Properties
    public Genero genero;
    protected String domicilio;
    protected boolean isPremium ;
    protected TipoDePlan tipoDePlan;
    protected boolean estaLogueado;
    protected Biblioteca biblioteca; // arreglo de ids de playlists

    //endregion

    //region Constructor
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String userName, String password, String fechaNacimiento) {
        super(nombre, apellido, email, userName, password, fechaNacimiento);
    }
//endregion

//region Getters y Setters

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public TipoDePlan getTipoDePlan() {
        return tipoDePlan;
    }

    public void setTipoDePlan(TipoDePlan tipoDePlan) {
        this.tipoDePlan = tipoDePlan;
    }

    public boolean isEstaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }


//endregion

//region Overrides

    @Override
    public String toString() {
        return "Cliente <<" +
                "Genero: " + genero +
                ", Domicilio: " + domicilio +
                ", IsPremium: " + isPremium +
                ", Tipo de plan: " + tipoDePlan +
                ", EstaLogueado: " + estaLogueado +
                ", Biblioteca: " + biblioteca +
                " >>";
    }


//endregion

}
