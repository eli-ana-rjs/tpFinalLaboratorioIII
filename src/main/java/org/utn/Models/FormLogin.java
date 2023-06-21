package org.utn.Models;

import org.utn.Menu.MenuAdmin;
import org.utn.Menu.MenuCliente;

import java.util.Scanner;

public class FormLogin {

    public static void dibujarMenu() {

        Login login = new Login();

        boolean seLogueo = false;
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuCliente menuCliente = new MenuCliente();

        try {
            while (login.tieneIntentosRestantes() && !seLogueo) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Email : ");
                String email = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                seLogueo = login.iniciarSesion(email, password);

                if (!seLogueo) {
                    System.out.println("Email o password incorrectas. Intente nuevamente ");
                }
            }

            if (Login.estaLogueado()) {

                if (Login.esAdministrador()) {
                    menuAdmin.iniciarMenuAdmin();
                } else if(!Login.getLogueado().isPremium()){
                    menuCliente.iniciarMenuClienteFree();
                } else {
                    menuCliente.iniciarMenuClientePremium();
                }
            } else {
                System.out.println("Intentos agotados. Por favor registrese...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}

