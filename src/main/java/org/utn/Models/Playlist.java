package org.utn.Models;
import java.util.ArrayList;

public class Playlist {

    private static int id; // incremento en metodos, esto no se serializa
    private int idPlaylist;
    public ArrayList<Cancion> playlist = new ArrayList<>();

}
