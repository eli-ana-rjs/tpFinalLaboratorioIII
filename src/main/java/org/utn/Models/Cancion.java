package org.utn.Models;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Milagros Pecar
 * @version 1.0
 */
public class Cancion implements Serializable {

    /**
     * Constante PI
     */
    private String nombre;
    /**
     * Constante PI
     */
    private String artista;
    /**
     * Constante PI
     */
    private String album;
    /**
     * Constante PI
     */
    private String duracion;
    /**
     * Constante PI
     */
    private String comentarios;
    /**
     * Constante PI
     */
    private GeneroCancion genero;
    /**
     * Constante PI
     */
    private int idCancion;


    //region Constructores

    /**
     * Constructor vacio de la clase Cancion
     */
    public Cancion() {
    }

    /**
     * Constructor de la clase Cancion
     * @param nombre nombre de la cancion
     * @param artista artista a quien pertenece la cancion
     * @param album album al cual pertenece una cancion
     * @param duracion duracion de la cancion
     * @param comentarios comentarios sobre la cancion
     * @param genero genero de la cancion
     */
    public Cancion(String nombre, String artista, String album, String duracion, String comentarios, GeneroCancion genero) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.comentarios = comentarios;
        this.genero = genero;

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

    public GeneroCancion getGenero() {
        return genero;
    }

    public void setGenero(GeneroCancion genero) {
        this.genero = genero;
    }

    //endregion

    //region OVerrides

    @Override
    public String toString() {
        return "<< " +
                "Nombre: " + nombre  +
                ", Artista: " + artista  +
                ", Album: " + album +
                ", Duracion: " + duracion  +
                ", Comentarios: " + comentarios  +
                ", Genero: " + genero +
                ", IdCancion: " + idCancion +
                " >>";
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

    //endregion
}
