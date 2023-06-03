package org.utn.Models;

import java.util.ArrayList;

public class Cliente extends Usuario{

    //region Properties
    public Genero genero;
    protected String domicilio;
    protected boolean isPremium ;
    protected TipoDePlan tipoDePlan;
    protected boolean estaLogueado;
    protected Biblioteca biblioteca;

    //endregion

    private ArrayList<Cancion> misCanciones = new ArrayList<Cancion>();
    private ArrayList<Playlist> miPlaylist = new ArrayList<Playlist>();

    //region Constructor
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String userName, String password, String fechaNacimiento) {
        super(nombre, apellido, email, userName, password, fechaNacimiento);
    }
//endregion

//region Getters y Setters

    public ArrayList<Cancion> getMisCanciones() {
        return misCanciones;
    }

    public void setMisCanciones(ArrayList<Cancion> misCanciones) {
        this.misCanciones = misCanciones;
    }

    public ArrayList<Playlist> getMiPlaylist() {
        return miPlaylist;
    }

    public void setMiPlaylist(ArrayList<Playlist> miPlaylist) {
        this.miPlaylist = miPlaylist;
    }


//endregion

}
