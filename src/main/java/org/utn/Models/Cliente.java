package org.utn.Models;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {

    //region Properties
    public Genero genero;
    private String domicilio;
    private boolean premium ;
    private TipoDePlan tipoDePlan;
    private String fechaNacimiento;

    //protected Biblioteca biblioteca; // arreglo de ids de playlists

    //endregion


    //protected Biblioteca biblioteca;

   // private ArrayList<Cancion> misCanciones = new ArrayList<Cancion>();
   // private ArrayList<Playlist> miPlaylist = new ArrayList<Playlist>();


    //region Constructor
    public Cliente() {
        super();
    }


    public Cliente(String nombre, String apellido, String email, String password, int id,
                   Genero genero, String domicilio, boolean premium, TipoDePlan tipoDePlan, String fechaNacimiento) {
        super(nombre, apellido, email, password, id);
        this.genero = genero;
        this.domicilio = domicilio;
        this.premium = premium;
        this.tipoDePlan = tipoDePlan;
        this.fechaNacimiento = fechaNacimiento;
    }


    //endregion

//region Getters y Setters

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public TipoDePlan getTipoDePlan() {
        return tipoDePlan;
    }

    public void setTipoDePlan(TipoDePlan tipoDePlan) {
        this.tipoDePlan = tipoDePlan;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //endregion


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append(", Id Cliente=").append(id);

        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append("genero=").append(genero);
        sb.append(", domicilio='").append(domicilio).append('\'');


        sb.append(", password='").append(password).append('\'');

        sb.append(", isPremium=").append(premium);
        sb.append(", tipoDePlan=").append(tipoDePlan);

        sb.append(", isAdmin=").append(admin);

        //sb.append(", biblioteca=").append(biblioteca);
       // sb.append(", misCanciones=").append(misCanciones);
        //sb.append(", miPlaylist=").append(miPlaylist);


        sb.append('}');
        return sb.toString();
    }

    // region EQUALS & HASHCODE



    //endregion
}
