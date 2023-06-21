package org.utn.Models;
import org.utn.Repositorios.PlaylistPrivadaRepo;
import org.utn.Repositorios.PlaylistPublicaRepo;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    //Muestra las playlist publicas y las privadas del cliente
    public void mostrarBibliotecaCliente(int idCliente){
        PlaylistPrivadaRepo playlistPrivadaRepo = new PlaylistPrivadaRepo();
        PlaylistPublicaRepo playlistPublicaRepo = new PlaylistPublicaRepo();
        List<PlaylistPrivada> playlistPrivadas = new ArrayList<>();
        playlistPrivadas = playlistPrivadaRepo.listar();
        List<PlaylistPublica> playlistPublicas = new ArrayList<>();
        GestionClientes gestionClientes = new GestionClientes();
        Cliente cliente = new Cliente();

        cliente = gestionClientes.buscarClienteId(idCliente);

        if (cliente.isPremium()){
            System.out.println("Playlist Privadas");
            for (PlaylistPrivada playlistPrivada : playlistPrivadas){
                if (playlistPrivada.getIdCliente() == idCliente){
                    System.out.println(playlistPrivada);
                }
            }
        }
        System.out.println("Playlist Publicas");
        for (PlaylistPublica playlistPublica : playlistPublicas) {
            System.out.println(playlistPublica);
        }
    }

    public void ingresoPlaylistUsuarioFree(int idCliente){
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        int idPlaylist=0;
        PlaylistPublica playlistActiva;
        System.out.println("Ingrese ID de la playlist a la que desea ingresar");
        try {
            idPlaylist = scanner.nextInt();
            scanner.reset();
        }
        catch (InputMismatchException e){
            e.getMessage();
        }

        playlistActiva = gestionPlaylistPublica.existePlaylist(idPlaylist);
        try {

            if (playlistActiva != null){
                System.out.println("1. Ver canciones de la playlist");
                //gestionPlaylistPublica.verCanciones(playlistActiva);
                //menuPlaylistActiva(playlistActiva);
            }
            else {
                throw new IllegalArgumentException("ID no existe, ingrese otro ID");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        menuPlaylistActivaFree(playlistActiva);


    }

    //Menu de ingreso a Playlist Privada
    public void ingresoPlaylistUsuarioPremium(int idCliente){
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
        int idPlaylist=0;
        PlaylistPrivada playlistActiva;
        System.out.println("Ingrese ID de la playlist a la que desea ingresar");
        try{
            idPlaylist = scanner.nextInt();
            scanner.reset();
        }
        catch (InputMismatchException e){
            e.getMessage();
        }
        int opcion;
        playlistActiva = gestionPlaylistPrivada.existePlaylist(idPlaylist);
        try {
            if (playlistActiva != null && playlistActiva.getIdCliente() == idCliente){
                System.out.println("Que desea hacer?");
                System.out.println("1. Ver canciones de la playlist");
                System.out.println("2. Crear nueva playlist");
                opcion = scanner.nextInt();
                scanner.reset();
                switch (opcion){
                    case 1: gestionPlaylistPrivada.verCanciones(playlistActiva);
                        menuPlaylistActivaPremium(playlistActiva);
                        break;
                    case 2: gestionPlaylistPrivada.crearPlaylist(idCliente);
                        break;
                }

            } else {
                throw new IllegalArgumentException("ID no existe, ingrese otro ID");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }
    }

    //Menu cuando ya se ingreso a una playlist particular
    public void menuPlaylistActivaPremium(PlaylistPrivada playlistPrivActiva){
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPrivada gestionPlaylistPriv = new GestionPlaylistPrivada();
        int opcion;
        System.out.println("Que desea hacer?");
        System.out.println("1. Escuchar cancion");
        System.out.println("2. Agregar cancion");
        System.out.println("3. Eliminar cancion");
        opcion = scanner.nextInt();
        switch (opcion){
            case 1: //escuchar cancion
                break;
            case 2: gestionPlaylistPriv.agregarCancion(playlistPrivActiva);
                break;
            case 3: gestionPlaylistPriv.eliminarCancion(playlistPrivActiva);
                break;
        }
    }

    public void menuPlaylistActivaFree(PlaylistPublica playlistPubActiva){
        Scanner scanner = new Scanner(System.in);
        GestionPlaylistPublica gestionPlaylistPub = new GestionPlaylistPublica();
        System.out.println("1. Escuchar cancion");
        //escuchar cancion
    }
}
