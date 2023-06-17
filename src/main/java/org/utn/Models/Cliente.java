package org.utn.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario implements Serializable {

    //region Properties
    public Genero genero;
    protected String domicilio;
    protected boolean isPremium ;
    protected TipoDePlan tipoDePlan;

    protected boolean estaLogueado;
    protected Biblioteca biblioteca; // arreglo de ids de playlists

    //endregion


    //protected Biblioteca biblioteca;

   // private ArrayList<Cancion> misCanciones = new ArrayList<Cancion>();
   // private ArrayList<Playlist> miPlaylist = new ArrayList<Playlist>();


    //region Constructor
    public Cliente() {
    }

    /*
    public Cliente(String nombre, String apellido, String email, String userName, String password, String fechaNacimiento) {
        super(nombre, apellido, email, userName, password, fechaNacimiento);
    }*/



    public Cliente(String nombre, String apellido, String email, String fechaNacimiento, String userName, String password, Genero genero, String domicilio, boolean isPremium, TipoDePlan tipoDePlan) {
        super(nombre, apellido, email, fechaNacimiento, userName, password);
        this.genero = genero;
        this.domicilio = domicilio;
        this.isPremium = isPremium;
        this.tipoDePlan = tipoDePlan;

    }


    //endregion

//region Getters y Setters

    /*
    public ArrayList<Cancion> getMisCanciones() {
        return misCanciones;

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


    */
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

    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public TipoDePlan getTipoDePlan() {
        return tipoDePlan;
    }

    public void setTipoDePlan(TipoDePlan tipoDePlan) {
        this.tipoDePlan = tipoDePlan;
    }

    @Override
    public boolean isEstaLogueado() {
        return estaLogueado;
    }

    @Override
    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    //endregion


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append(", idUsuario=").append(id);

        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", fechaNacimiento='").append(fechaNacimiento).append('\'');
        sb.append("genero=").append(genero);
        sb.append(", domicilio='").append(domicilio).append('\'');

        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');

        sb.append(", isPremium=").append(isPremium);
        sb.append(", tipoDePlan=").append(tipoDePlan);
        sb.append(", estaLogueado=").append(estaLogueado);
        sb.append(", isAdmin=").append(isAdmin);

        //sb.append(", biblioteca=").append(biblioteca);
       // sb.append(", misCanciones=").append(misCanciones);
        //sb.append(", miPlaylist=").append(miPlaylist);


        sb.append('}');
        return sb.toString();
    }

    // region EQUALS & HASHCODE



    //endregion
}
