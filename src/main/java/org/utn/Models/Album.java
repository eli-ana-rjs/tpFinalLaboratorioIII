package org.utn.Models;

import java.util.ArrayList;

public class Album {

    private String nombreAlbum;
    private String artista;
    private ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
    private int duracion;

    //region Constructores
    public Album() {
    }

    public Album(String nombreAlbum, String artista, ArrayList<Cancion> listaCanciones, int duracion) {
        this.nombreAlbum = nombreAlbum;
        this.artista = artista;
        this.listaCanciones = listaCanciones;
        this.duracion = duracion;
    }

    //endregion

    //region Getters y Setters

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public ArrayList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //endregion

    //region Overrides

    @Override
    public String toString() {
        return "Album <<" +
                "Nombre del album: " + nombreAlbum + '\'' +
                ", Artista: " + artista + '\'' +
                ", Canciones: " + listaCanciones +
                ", Duracion: " + duracion +
                ">>";
    }

    //endregion


}
