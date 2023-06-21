package org.utn.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PlaylistPrivada extends Playlist implements Serializable {
    private int idCliente;

    //region Constructores
    public PlaylistPrivada() {
    }

    public PlaylistPrivada(String nombre, int idPlaylist, List<Cancion> listaCanciones, int idCliente) {
        super(nombre, idPlaylist, listaCanciones);
        this.idCliente = idCliente;
    }

    //endregion
int
    //region Getters y Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistPrivada that = (PlaylistPrivada) o;
        return idPlaylist == that.idPlaylist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlaylist);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}