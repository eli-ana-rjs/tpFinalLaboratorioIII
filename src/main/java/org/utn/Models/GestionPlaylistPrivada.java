package org.utn.Models;

import org.utn.Repositorios.PlaylistPrivadaRepo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestionPlaylistPrivada{
    private PlaylistPrivadaRepo repoPlaylistPriv = new PlaylistPrivadaRepo();

    //region Constructor
    public GestionPlaylistPrivada() {
    }
    //endregion

    //Crear Playlist
    public void crearPlaylist(int idCliente){
        Scanner scanner = new Scanner(System.in);
        PlaylistPrivada playlistPrivada = new PlaylistPrivada();
        int ultimoID=0;
        System.out.println("Ingrese nombre de la playlist");
        playlistPrivada.setNombre(scanner.nextLine());
        playlistPrivada.setIdCliente(idCliente);
        ultimoID = buscarUltimoID();
        playlistPrivada.setIdPlaylist(++ultimoID);
        repoPlaylistPriv.agregar(playlistPrivada);
        System.out.println("Playlist creada con exito!");
        scanner.close();
    }

    //Agregar cancion a Playlist
    public void agregarCancion(PlaylistPrivada playlistPrivActiva){
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
                playlistPrivActiva.listaCanciones.add(cancion);
                repoPlaylistPriv.modificar(playlistPrivActiva);
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
    public void eliminarCancion(PlaylistPrivada playlistPrivActiva){
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
            cancion = gestionCancion.existeEnPlaylist(idEliminar, playlistPrivActiva.getListaCanciones());
            if (cancion != null) {
                playlistPrivActiva.listaCanciones.remove(cancion);
                repoPlaylistPriv.modificar(playlistPrivActiva);
                System.out.println("Cancion eliminada con exito");
            } else {
                throw new IllegalArgumentException("No existe esa cancion, ingrese otro id");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //Mostrar todas las canciones de la playlist
    public void verCanciones(PlaylistPrivada playlistActiva){
        playlistActiva.getListaCanciones().forEach(System.out::println);
    }

    //Busca una playlist por ID y retorna true o false si existe
    public boolean existeBoolean(int idPlaylist){
        List<PlaylistPrivada> playlistPrivadas = new ArrayList<>();
        playlistPrivadas = repoPlaylistPriv.listar();
        for (PlaylistPrivada playlistPriv : playlistPrivadas){
            if (playlistPriv.getIdPlaylist() == idPlaylist){
                return true;
            }
        }
        return false;
    }

    //Busca una playlist por ID y retorna el objeto Playlist
    public PlaylistPrivada existePlaylist(int idPlaylist){
        List<PlaylistPrivada> playlistPrivadas = new ArrayList<>();
        playlistPrivadas = repoPlaylistPriv.listar();
        for (PlaylistPrivada playlistPriv : playlistPrivadas){
            if (playlistPriv.getIdPlaylist() == idPlaylist){
                return playlistPriv;
            }
        }
        return null;
    }

    //Busca ultimo ID de playlist
    public int buscarUltimoID(){
        List<PlaylistPrivada> playlistPrivadas = new ArrayList<>();
        playlistPrivadas = repoPlaylistPriv.listar();
        int ultimoID = 3;
        for (PlaylistPrivada playlistPriv : playlistPrivadas){
            ultimoID = playlistPriv.getIdPlaylist();
        }
        return ultimoID;
    }

    //Eliminar una playlist
    public void eliminarPlaylist (int idPlaylist){
        PlaylistPrivada playlistPrivada = new PlaylistPrivada();
        playlistPrivada = existePlaylist(idPlaylist);
        System.out.println(playlistPrivada);
        if (playlistPrivada != null){
            repoPlaylistPriv.eliminar(playlistPrivada);
            System.out.println("Playlist eliminada con exito");
        } else {
            System.out.println("Ingrese un ID valido");
        }
    }
}
