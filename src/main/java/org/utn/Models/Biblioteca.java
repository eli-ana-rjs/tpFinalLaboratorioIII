package org.utn.Models;

import org.utn.Repositorios.PlaylistPrivadaRepo;
import org.utn.Repositorios.PlaylistPublicaRepo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    //Muestra las playlist publicas y las privadas del cliente
    public void mostrarBibliotecaCliente(int idCliente) {
        PlaylistPrivadaRepo playlistPrivadaRepo = new PlaylistPrivadaRepo();
        PlaylistPublicaRepo playlistPublicaRepo = new PlaylistPublicaRepo();
        List<PlaylistPrivada> playlistPrivadas = new ArrayList<>();
        playlistPrivadas = playlistPrivadaRepo.listar();
        List<PlaylistPublica> playlistPublicas = new ArrayList<>();
        playlistPublicas = playlistPublicaRepo.listar();
        GestionClientes gestionClientes = new GestionClientes();
        Cliente cliente = new Cliente();
        cliente = gestionClientes.buscarClienteId(idCliente);
        System.out.println("Playlist Publicas");
        for (PlaylistPublica playlistPublica : playlistPublicas) {
            System.out.println(playlistPublica);
        }

        if (cliente.isPremium()) {
            System.out.println("Playlist Privadas");
            for (PlaylistPrivada playlistPrivada : playlistPrivadas) {
                if (playlistPrivada.getIdCliente() == idCliente) {
                    System.out.println(playlistPrivada);
                }
            }
        }
    }

    //Menu ingreso a playlist usuario Free
    public void ingresoPlaylistUsuarioFree(int idCliente) {
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        int idPlaylist = 0;
        PlaylistPublica playlistActiva;
        System.out.println("Ingrese ID de la playlist a la que desea escuchar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        playlistActiva = gestionPlaylistPublica.existePlaylist(idPlaylist);
        try {
            if (playlistActiva != null) {
                gestionPlaylistPublica.verCanciones(playlistActiva);
                menuPlaylistPublica(playlistActiva);
            } else {
                throw new IllegalArgumentException("ID no existe, ingrese otro ID");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //Menu de ingreso a Playlist usuario Premium

    public void eliminarDesdeBiblioteca(){

        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        int idPlaylist = 0;

        System.out.println("Ingrese ID de la playlist que desea eliminar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        if (idPlaylist <= 3){
            System.out.println("Ingrese un ID de una playlist propia");
        } else {
            gestionPlaylistPrivada.eliminarPlaylist(idPlaylist);
        }
    }

    public void escucharDesdeBiblioteca(){

        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        int idPlaylist = 0;
        Playlist playlistActiva ;

        System.out.println("Ingrese ID de la playlist que desea escuchar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        } catch (InputMismatchException e) {
            e.getMessage();
        }
        try {
            if (idPlaylist <= 3) {
                playlistActiva = gestionPlaylistPublica.existePlaylist(idPlaylist);
                menuPlaylistPublica((PlaylistPublica) playlistActiva);
            } else if (idPlaylist > 3) {
                playlistActiva = gestionPlaylistPrivada.existePlaylist(idPlaylist);
                menuPlaylistPrivada((PlaylistPrivada) playlistActiva);
            } else {
                throw new IllegalArgumentException("ID no existe, ingrese otro ID");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public PlaylistPrivada crearPlaylistDesdeBiblioteca(int idCliente){
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        PlaylistPrivada playlistPrivada = gestionPlaylistPrivada.crearPlaylist(idCliente);

        return playlistPrivada;
    }

    //Menu usuario Premium cuando ya ingreso a una playlist privada
    public void menuPlaylistPrivada(PlaylistPrivada playlistPrivActiva) {
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPriv = new GestionPlaylistPrivada();
        int opcion;
        System.out.println("Que desea hacer?");
        System.out.println("1. Escuchar cancion");
        System.out.println("2. Agregar cancion");
        System.out.println("3. Eliminar cancion");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1: //escuchar cancion
               GestionCancion gestionCancion = new GestionCancion();


               gestionCancion.menuReproduccionPlaylistPrivada(playlistPrivActiva.getIdPlaylist());
                break;
            case 2:
                gestionPlaylistPriv.agregarCancion(playlistPrivActiva);
                break;
            case 3:
                gestionPlaylistPriv.eliminarCancion(playlistPrivActiva);
                break;
        }
    }

    //Menu usuarios Free y Premium que accedieron a una playlist Publica
    public void menuPlaylistPublica(PlaylistPublica playlistPubActiva) {
        GestionCancion gestionCancion = new GestionCancion();

        gestionCancion.menuReproduccionPlaylistPrivada(playlistPubActiva.getIdPlaylist()); // revisar
    }
}
