package org.utn.Models;

public  abstract class Usuario {

    protected String nombre;
    protected String apellido;
    protected String email;
    protected String fechaNacimiento;
    protected String userName;
    protected String password;
    private static int id;
    protected int idUsuario = id;


    //region Constructores
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String userName, String password, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.idUsuario = ++Usuario.id;
    }

    public Usuario(String userName, String password){
        this.userName = userName;
        this.password = password;
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
//endregion

}
