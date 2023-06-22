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

    //region Getters y Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //endregion

    @Override
    public String toString() {
        return super.toString();
    }
}