package org.utn.Models;

import org.utn.Menu.MenuAdmin;
import org.utn.Menu.MenuCliente;

import java.util.Scanner;
/**
 * Esta clase se encarga de dibujar el menu de login y de llamar a los metodos de la clase Login
 * @author Eliana Rojas
 * @version 1.0
 * @see Login
 */
public class FormLogin {

    /**
     * Mientras el usuario no este logueado y le queden intentos, se solocita email y password
     * Si se loguea cambia el atributo seLogue a true.
     * Una vez que esta logueado se chequea su rol: admin, cliente free o cliente premium y se dibuja el menu que corresponda
     */
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

