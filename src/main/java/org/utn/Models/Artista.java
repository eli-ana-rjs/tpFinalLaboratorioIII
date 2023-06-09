package org.utn.Models;

public class Artista {

    private String nombreArtista;
    private String genero;

    //region Constructores

    public Artista() { 
    }

    public Artista(String nombreArtista, String genero) {
        this.nombreArtista = nombreArtista;
        this.genero = genero;
    }

    //endregion

    //region Getters y Setters

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    //endregion

    //region Overrides

    @Override
    public String toString() {
        return "Artista <<" +
                "Nombre: " + nombreArtista + '\'' +
                ", Genero: " + genero + '\'' +
                ">>";
    }
    //endregion

}
