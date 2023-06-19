package org.utn.Models;

import org.utn.Repositorios.CancionRepo;
import org.utn.Repositorios.PlaylistPrivadaRepo;

import java.util.Scanner;

public class GestionPlaylistPrivada{
    private PlaylistPrivadaRepo repoPlaylistPriv = new PlaylistPrivadaRepo();
    private PlaylistPrivada playlistPrivada = new PlaylistPrivada();
    //region Constructor
    public GestionPlaylistPrivada() {
    }
    //endregion

    //Crear Playlist
    public void crearPlaylist(int idCliente){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre de la playlist");
        playlistPrivada.setNombre(scanner.nextLine());
        playlistPrivada.setIdCliente(idCliente);
        repoPlaylistPriv.agregar(playlistPrivada);
        scanner.close();
        System.out.println("Playlist creada con exito!");
    }

    //Agregar cancion a Playlist
    public void agregarCancion(){
        Scanner scanner = new Scanner(System.in);
        Cancion cancion = new Cancion();
        int idCancion=0;
        //gestionCancion.listar
        System.out.println("Ingrese ID de la cancion que desea agregar a su playlist");
        try{
            cancion = cancion. //buscar y que retorne la cancion si existe, o null sino
            if (cancion != null) {
                playlistPrivada.listaCanciones.add(cancion);
            } else {
                throw new IllegalArgumentException("No existe esa cancion, ingrese otro id");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        scanner.close();
        repoPlaylistPriv.modificar(playlistPrivada);
        System.out.println("Cancion agregada con exito!");
    }

    //Eliminar cancion de la Playlist
    public void eliminarCancion(){
        Scanner scanner = new Scanner(System.in);
        int idEliminar;
        System.out.println("Ingrese id de la cancion que desea eliminar de su playlist");
        idEliminar = scanner.nextInt();
        try {
            playlistPrivada.getListaCanciones(); //funcion que le pase una lista de canciones y un id, y me retorne el obj cancion si existe
            if (cancion.existe) {
                playlistPrivada.listaCanciones.remove(cancion);
            } else {
                throw new IllegalArgumentException("No existe esa cancion, ingrese otro id");
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        repoPlaylistPriv.modificar(playlistPrivada);
    }

    //Mostrar todas las canciones de la playlist
    public void verCanciones(){
        repoPlaylistPriv.listar().forEach(System.out::println);
    }
}
