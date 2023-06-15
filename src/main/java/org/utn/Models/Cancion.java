package org.utn.Models;

import java.io.Serializable;
import java.util.Objects;

public class Cancion implements Serializable {

    private String nombre;
    private String artista;
    private String album;
    private String duracion;
    private String comentarios;
    private GeneroCancion genero;
    private static int id; // Como los atributos static no se persisten nunca va a aumentar el num de id. Agregar incremental metodo
    private int idCancion;

    //region Constructores

    public Cancion() {
    }

    public Cancion(String nombre, String artista, String album, String duracion, String comentarios) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.comentarios = comentarios;
        this.idCancion = ++Cancion.id;
    }

    //endregion

    //region Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }


    //endregion

    //region OVerrides


    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                ", duracion='" + duracion + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", genero=" + genero +
                ", idCancion=" + idCancion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return idCancion == cancion.idCancion && Objects.equals(nombre, cancion.nombre) && Objects.equals(artista, cancion.artista) && Objects.equals(album, cancion.album) && Objects.equals(duracion, cancion.duracion) && Objects.equals(comentarios, cancion.comentarios) && genero == cancion.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, artista, album, duracion, comentarios, genero, idCancion);
    }


    //
}
