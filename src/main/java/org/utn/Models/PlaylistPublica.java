package org.utn.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPublica extends Playlist implements Serializable {


    //region Constructores

    public PlaylistPublica() {
    }
    public PlaylistPublica(String nombre, int idPlaylist, List<Cancion> listaCanciones) {
        super(nombre, idPlaylist, listaCanciones);
    }

    //endregion
}
