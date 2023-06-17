package org.utn.Models;

import org.utn.Repositorios.CancionRepo;

public class GestionCancion {

    CancionRepo repo = new CancionRepo();

    public void mostrarCanciones(){

        repo.listar();
    }

    public void agregarCancion(Cancion c){
    repo.agregar(c);
    }

    public void eliminarCancion(Cancion c){

        repo.eliminar(c);
    }

    public boolean buscarCancion(Cancion c){
       boolean encontrar = false;
        repo.buscar(c);

        return encontrar;
    }

    public void modificarNombreCancion(Cancion objeto, String nombre) {
    }
}
