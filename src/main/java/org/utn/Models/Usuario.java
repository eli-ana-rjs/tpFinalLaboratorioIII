package org.utn.Models;

import java.util.Objects;

public  abstract class Usuario {

    protected String nombre;
    protected String apellido;
    protected String email;
    protected String password;
    protected boolean admin;
    private static int contadorId = 0 ;
    protected int id;
    protected boolean usuarioActivo = true;


    //region Constructores
    public Usuario() {
        this.id = ++Usuario.contadorId;
    }

    public Usuario(String nombre, String apellido, String email,String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.admin = false;
        this.id = ++Usuario.contadorId;
    }

    // constructor para leer un cliente del json con un id que ya existe
    public Usuario(String nombre, String apellido, String email, String password, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.admin = false;
        this.id = id;
    }

    //endregion

    //region Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Usuario.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    //endregion

    // region toString

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Datos del Usuario con id: ");
        sb.append(id).append('\'');
        sb.append("Nombre = '").append(nombre).append('\'');
        sb.append(", Apellido = '").append(apellido).append('\'');
        sb.append(", email = '").append(email).append('\'');
        sb.append(", password = '").append(password).append('\'');
        sb.append(", isAdmin = '").append(admin).append('\'');

        return sb.toString();
    }

    //endregion

    // region Equals & HashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }
}
