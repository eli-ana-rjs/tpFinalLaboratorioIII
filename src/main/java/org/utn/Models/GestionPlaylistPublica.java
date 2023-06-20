package org.utn.Models;

import org.utn.Repositorios.PlaylistPrivadaRepo;
import org.utn.Repositorios.PlaylistPublicaRepo;

public class GestionPlaylistPublica {

    private PlaylistPublicaRepo repoPlaylistPub = new PlaylistPublicaRepo();

    public GestionPlaylistPublica() {
    }

    public void crearPlaylistPublica(PlaylistPublica playlistPublica){

        repoPlaylistPub.agregar(playlistPublica);
    }


}
