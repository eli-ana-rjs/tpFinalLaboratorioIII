package org.utn.Models;

public  abstract class Usuario {

    protected String nombre;
    protected String apellido;
    protected String email;
    protected String fechaNacimiento;
    protected String userName;
    protected String password;
    protected boolean estaLogueado;
    protected boolean isAdmin;
    private static int id;
    protected int idUsuario = id;


    //region Constructores
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String fechaNacimiento, String userName, String password, boolean estaLogueado, boolean isAdmin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.userName = userName;
        this.password = password;
        this.estaLogueado = estaLogueado;
        this.isAdmin = isAdmin;
        this.idUsuario = ++Usuario.id;
    }

    public Usuario(String nombre, String apellido, String email, String userName, String password, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;

    }

    public Usuario(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    //endregion

    //region Getters y Setters

    public int getIdUsuario() {
        return idUsuario;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstaLogueado() {
        return estaLogueado;
    }

    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    //endregion

    // region toString

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Datos del Usuario con id: ");
        sb.append(idUsuario).append('\'');
        sb.append("Nombre = '").append(nombre).append('\'');
        sb.append(", Apellido = '").append(apellido).append('\'');
        sb.append(", email = '").append(email).append('\'');
        sb.append(", Fecha de Nacimiento = '").append(fechaNacimiento).append('\'');
        sb.append(", userName = '").append(userName).append('\'');
        sb.append(", password = '").append(password).append('\'');
        sb.append(", estaLogueado = '").append(estaLogueado).append('\'');
        sb.append(", isAdmin = '").append(isAdmin).append('\'');

        return sb.toString();
    }

    //endregion



}
