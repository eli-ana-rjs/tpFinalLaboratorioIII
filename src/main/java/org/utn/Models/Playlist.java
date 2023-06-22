package org.utn.Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Playlist {

    protected String nombre;
    protected int idPlaylist;
    protected List<Cancion> listaCanciones = new ArrayList<Cancion>();

    //region Constructores
    public Playlist() {
    }

    public Playlist(String nombre, int idPlaylist, List<Cancion> listaCanciones) {
        this.nombre = nombre;
        this.idPlaylist = idPlaylist;
        this.listaCanciones = listaCanciones;
    }

    //endregion

    //region Getters y Setters

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    //endregion

    @Override
    public String toString() {
        return "Playlist: " + nombre + "\t| ID: " +idPlaylist +"\nCanciones:" + listaCanciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return idPlaylist == playlist.idPlaylist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlaylist);
    }
}