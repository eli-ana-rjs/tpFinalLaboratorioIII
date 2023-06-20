package org.utn.Models;

import java.io.Serializable;

public class Login implements Serializable {

    static Cliente logueado = null;
    static int idLogueado = logueado.getId();

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
            logueado.getId();
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

    public static int idClienteLogueado(){
        return logueado.getId();
    }

}
