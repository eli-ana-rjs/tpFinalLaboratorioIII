package org.utn.Models;

import java.io.Serializable;

public class Login implements Serializable {

   // static Cliente logueado = null;


    private static Cliente logueado = null;


    private int intentosRestantes;

    GestionClientes gestionClientes = new GestionClientes();


    public Login() {
        this.intentosRestantes = 3;
    }

    public boolean tieneIntentosRestantes() {
        return this.intentosRestantes > 0;
    }

    public void setIntentosRestantes(int intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    public boolean iniciarSesion(String email, String password) {

        Cliente cliente = gestionClientes.existeCliente(email);

        if (cliente.getPassword().equals(password)) {

            logueado = cliente;

            return true;
        }
        this.intentosRestantes--;
        return false;
    }

    public static boolean estaLogueado(){
        return logueado != null;
    }

    public static boolean esAdministrador(){
        return logueado.isAdmin();
    }

    public static Cliente getLogueado() {
        return logueado;
    }

    public static void setLogueado(Cliente logueado) {
        Login.logueado = logueado;
    }
}
