package org.utn.Models;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private static int id=0;
    private int idPlaylist;
    private List<Cancion> playlist = new ArrayList<Cancion>();

    //region Constructores
    public Playlist() {
    }

    public Playlist(ArrayList<Cancion> playlist) {
        this.idPlaylist = ++id;
        this.playlist = playlist;
    }
    //endregion
    //region Getters y Setters
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public List<Cancion> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Cancion> playlist) {
        this.playlist = playlist;
    }
    //endregion
}
