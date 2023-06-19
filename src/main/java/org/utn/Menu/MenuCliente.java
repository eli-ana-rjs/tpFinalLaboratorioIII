package org.utn.Menu;

import org.utn.Models.Cliente;
import org.utn.Utilidades.Color;

import java.util.Scanner;

import static org.utn.Utilidades.Utilidades.dibujarRectanguloTexto;

public class MenuCliente {

    public void iniciarMenuClienteFree() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            mostrarMenuClienteFree();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:


                    break;
                case 2:


                    break;
                case 3:


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

    public void mostrarMenuClienteFree() {

        String titulo = "Bienvenido a Spoti-J";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Ver mis playlist");
        System.out.println("2. Seleccionar una Playlist");
        System.out.println("3. Reproducir...");
        System.out.println(Color.amarillo + "4. Salir" + Color.b);
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }

    public void iniciarMenuClientePremium() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            mostrarMenuClientePremium();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:


                    break;
                case 2:


                    break;
                case 3:


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

    public void mostrarMenuClientePremium() {

        String titulo = "Bienvenido a Spoti-J - Premium";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Ver mis playlist");
        System.out.println("2. Crear una playlist");
        System.out.println("2. Seleccionar una Playlist");
        System.out.println("3. Reproducir...");
        System.out.println(Color.amarillo + "4. Salir" + Color.b);
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }
}