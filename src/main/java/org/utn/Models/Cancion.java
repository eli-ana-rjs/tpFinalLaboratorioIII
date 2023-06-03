package org.utn.Models;

public class Cancion {

    private String nombre;
    private String artista;
    private String album;
    private String duracion;
    private String comentarios;
    private static int id;
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
}
