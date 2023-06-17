package org.utn.Menu;

import java.util.Scanner;

import static org.utn.Menu.Decorador.dibujarRectanguloTexto;

public class MenuAdmin {

    public void iniciarMenuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarSubMenuClientes("Gestion Clientes");
                    int opcionSubmenuClientes = scanner.nextInt();
                    manejarOpcionSubMenuClientes(opcionSubmenuClientes);

                    break;
                case 2:
                    mostrarSubMenuAdmin("Gestion Administradores");
                    int opcionSubMenuAdministradores = scanner.nextInt();
                    manejarOpcionSubMenuAdministradores(opcionSubMenuAdministradores);

                    break;
                case 3:
                    mostrarSubMenuCanciones("Gestion Canciones");
                    int opcionSubMenuCanciones = scanner.nextInt();
                    manejarOpcionSubMenuCanciones(opcionSubMenuCanciones);

                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número válido.");
                    break;
            }
        }

        scanner.close();
    }

    public void mostrarMenuPrincipal() {

        String titulo = "Menu Principal";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Gestion Clientes");
        System.out.println(Color.magenta + "2. Gestion Administradores");
        System.out.println(Color.verde + "3. Gestion Canciones");
        System.out.println(Color.amarillo + "4. Salir");
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }

    public void mostrarSubMenuClientes(String opcion) {

        String titulo = " Submenú de " + opcion ;
        dibujarRectanguloTexto(titulo);
        System.out.println("\n");

        System.out.println("1. Dar de alta un Cliente ");
        System.out.println("2. Modificar datos de un cliente ");
        System.out.println("3. Dar de baja un Cliente ");
        System.out.println("4. Listar todos los Clientes ");
        System.out.println("5. Volver al menú principal ");
        System.out.print("Elige una opción: ");
    }

    public void mostrarSubMenuAdmin(String opcion){

        String titulo = " Submenú de " + opcion;
        dibujarRectanguloTexto(titulo);

        System.out.println("1. Dar de alta un Administrador ");
        System.out.println("2. Modificar datos de un Administrador");
        System.out.println("3. Dar de baja un Administrador ");
        System.out.println("4. Listar todos los Administradores ");
        System.out.println("5. Volver al menú principal ");
        System.out.print("Elige una opción: ");

    }

    public void mostrarSubMenuCanciones(String opcion){

        String titulo = " Submenú de " + opcion;
        dibujarRectanguloTexto(titulo);

        System.out.println("1. Dar de alta una Cancion ");
        System.out.println("2. Modificar datos de una Cancion");
        System.out.println("3. Dar de baja una Cancion ");
        System.out.println("4. Listar todas las canciones ");
        System.out.println("5. Volver al menú principal ");
        System.out.print("Elige una opción: ");

    }

    public void manejarOpcionSubMenuClientes(int opcionSubMenuClientes) {
        switch (opcionSubMenuClientes) {
            case 1:
                System.out.println("Dando de alta un cliente...");
                break;
            case 2:
                System.out.println("Opción 2 del submenú 1 seleccionada.");
                break;
            case 3:
                break;

            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }

    public void manejarOpcionSubMenuAdministradores(int opcionSubMenuAdministradores) {
        switch (opcionSubMenuAdministradores) {
            case 1:
                System.out.println("\n Dando de alta un Admin...\n");
                break;
            case 2:
                System.out.println("Opción 2 del submenú 1 seleccionada.");
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }

    public void manejarOpcionSubMenuCanciones(int opcionSubMenuCanciones) {
        switch (opcionSubMenuCanciones) {
            case 1:
                System.out.println("Dando de alta una cancion...");
                break;
            case 2:
                System.out.println("Opción 2 del submenú 1 seleccionada.");
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }
}
