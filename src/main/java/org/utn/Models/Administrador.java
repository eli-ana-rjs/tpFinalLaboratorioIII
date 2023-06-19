package org.utn.Models;
import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    //region constructor
    public Administrador() {
    }

    public Administrador(String nombre, String apellido, String email, String password, int id) {
        super(nombre, apellido, email, password, id);
        this.admin = true;
    }

    //endregion
    public void escucharCancion(){

    }

    public void armarPlaylist(){

    }

    public void crearCliente(){

    }

    public void crearAdministrador(){

    }

    public void eliminarCliente(){

    }

    public void eliminarAdministrador(){

    }

    public void agregarCancion(){

    }



    public void eliminarCancion(){

    }

    public void modificarPlaylist(){

    }

    public void modificarCliente(){

    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Administrador: ");
        sb.append("Id Admin").append(id);
        sb.append("Nombre = '").append(nombre).append('\'');
        sb.append(", Apellido = '").append(apellido).append('\'');
        sb.append(", email = '").append(email).append('\'');
        sb.append(", password = '").append(password).append('\'');
        sb.append(", isAdmin = '").append(admin).append('\'');

        return sb.toString();
    }

    //endregion
}
