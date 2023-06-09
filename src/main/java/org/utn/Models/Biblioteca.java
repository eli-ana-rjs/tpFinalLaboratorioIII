package org.utn.Models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   private List<Playlist> biblioteca = new ArrayList<Playlist>();

    //region Constructores
    public Biblioteca() {
    }
    public Biblioteca(List<Playlist> biblioteca) {
        this.biblioteca = biblioteca;
    }
    //endregion
}
