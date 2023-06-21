package org.utn.Models;

import org.utn.Repositorios.PlaylistPrivadaRepo;
import org.utn.Repositorios.PlaylistPublicaRepo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestionPlaylistPublica {

    private PlaylistPublicaRepo repoPlaylistPub = new PlaylistPublicaRepo();

    //region Constructores
    public GestionPlaylistPublica() {
    }
    //endregion

    //Crear playlist publica
    public void crearPlaylist(){
        Scanner scanner = new Scanner(System.in);
        PlaylistPublica playlistPublica = new PlaylistPublica();
        int ultimoID=0;
        System.out.println("Ingrese nombre de la playlist");
        playlistPublica.setNombre(scanner.nextLine());
        ultimoID = buscarUltimoID();
        playlistPublica.setIdPlaylist(++ultimoID);
        repoPlaylistPub.agregar(playlistPublica);
        System.out.println("Playlist creada con exito!");
        scanner.close();
    }

    //Agregar cancion a Playlist
    public void agregarCancion(PlaylistPublica playlistPubActiva){
        Scanner scanner = new Scanner(System.in);
        GestionCancion gestionCancion = new GestionCancion();
        Cancion cancion = new Cancion();
        int idCancion=0;
        gestionCancion.mostrarTodas();
        System.out.println("Ingrese ID de la cancion que desea agregar a su playlist");
        try{
            idCancion = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Ingrese un numero");
        }
        finally {
            scanner.reset();
            scanner.close();
        }
        try {
            cancion =  gestionCancion.existe(idCancion);
            if (cancion != null) {
                playlistPubActiva.getListaCanciones().add(cancion);
                repoPlaylistPub.modificar(playlistPubActiva);
                System.out.println("Cancion agregada con exito!");
            } else {
                throw new IllegalArgumentException("No existe esa cancion, ingrese otro id");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    //Eliminar cancion de la Playlist
    public void eliminarCancion(PlaylistPublica playlistPubActiva){
        Scanner scanner = new Scanner(System.in);
        Cancion cancion = new Cancion();
        GestionCancion gestionCancion = new GestionCancion();
        int idEliminar=0;
        try {
            System.out.println("Ingrese id de la cancion que desea eliminar de su playlist");
            idEliminar = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Ingrese un numero");
        }
        finally {
            scanner.reset();
            scanner.close();
        }
        try {
            cancion = gestionCancion.existeEnPlaylist(idEliminar, playlistPubActiva.getListaCanciones());
            if (cancion != null) {
                playlistPubActiva.listaCanciones.remove(cancion);
                repoPlaylistPub.modificar(playlistPubActiva);
                System.out.println("Cancion eliminada con exito");
            } else {
                throw new IllegalArgumentException("No existe esa cancion, ingrese otro id");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //Busca una playlist por id y retorna true o false si existe
    public boolean existeBoolean(int idPlaylist){
        List<PlaylistPublica> playlistPublica = new ArrayList<>();
        playlistPublica = repoPlaylistPub.listar();
        for (PlaylistPublica playlistPub : playlistPublica){
            if (playlistPub.getIdPlaylist() == idPlaylist){
                return true;
            }
        }
        return false;
    }

    //Busca una playlist por ID y retorna el objeto Playlist
    public PlaylistPublica existePlaylist(int idPlaylist){
        List<PlaylistPublica> playlistPublicas = new ArrayList<>();
        playlistPublicas = repoPlaylistPub.listar();
        for (PlaylistPublica playlistPub : playlistPublicas){
            if (playlistPub.getIdPlaylist() == idPlaylist){
                return playlistPub;
            }
        }
        return null;
    }

    //Muestra las canciones de la playlist Publica
    public void verCanciones(PlaylistPublica playlistActiva){
        playlistActiva.getListaCanciones().forEach(System.out::println);
    }

    //Buscar ultimo iD
    public int buscarUltimoID(){
        List<PlaylistPublica> playlistPublicas = new ArrayList<>();
        playlistPublicas = repoPlaylistPub.listar();
        int ultimoID = 0;
        for (PlaylistPublica playlistPub : playlistPublicas){
            ultimoID = playlistPub.getIdPlaylist();
        }
        return ultimoID;
    }

}
