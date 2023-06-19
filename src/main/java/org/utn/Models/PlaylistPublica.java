package org.utn.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPublica extends Playlist implements Serializable {
    private List<Integer> idClientes = new ArrayList<Integer>();

    //region Constructores

    public PlaylistPublica() {
    }

    public PlaylistPublica(String nombre, List<Cancion> listaCanciones, List<Integer> idClientes) {
        super(nombre, listaCanciones);
        this.idClientes = idClientes;
    }

    //endregion

    //region Getters y Setters

    public List<Integer> getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(List<Integer> idClientes) {
        this.idClientes = idClientes;
    }
    //endregion
}
