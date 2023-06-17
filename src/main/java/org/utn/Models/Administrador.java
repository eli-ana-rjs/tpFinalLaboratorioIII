package org.utn.Models;
import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    //region constructor
    public Administrador() {
    }

    public Administrador(String nombre, String apellido, String email, String fechaNacimiento, String userName, String password, boolean estaLogueado, boolean isAdmin) {
        super(nombre, apellido, email, fechaNacimiento, userName, password);
        setAdmin(true);
    }
    //endregion

    //region metodos



    //endregion

}
