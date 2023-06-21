package org.utn.Menu;

import org.utn.Models.*;
import org.utn.Utilidades.Color;

import java.util.Scanner;

import static org.utn.Utilidades.Utilidades.dibujarRectanguloTexto;

/**
 * Esta clase se encarga de dibujar el menu de un cliente dependiendo si es free o premium
 * @author Eliana Rojas
 */
public class MenuCliente {

    GestionClientes gestionClientes = new GestionClientes();
    TipoDePlan tipoPlan;

    Biblioteca biblioteca = new Biblioteca();

    Cliente clienteLogueado = Login.getLogueado();
    int idClienteActual = clienteLogueado.getId();

    public void iniciarMenuClienteFree() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            mostrarMenuClienteFree();
            opcion = scanner.nextInt();



            switch (opcion) {
                case 1:

                    System.out.println("Mis playlist");

                    System.out.println("idClienteActual = " + idClienteActual);
                    biblioteca.mostrarBibliotecaCliente(idClienteActual);

                    break;
                case 2:

                    // Seleccionar una lista publica

                    break;
                case 3:

                    Cliente cliente = gestionClientes.buscarClienteId(clienteLogueado.getId());
                    gestionClientes.cambiarPlan(cliente);

                    System.out.println("Seleccione un Tipo de Plan ---> 1.INDIVIDUAL, 2.DUO, 3. FAMILIAR : ");
                    TipoDePlan.INDIVIDUAL.mostrarInformacionPlan();
                    TipoDePlan.DUO.mostrarInformacionPlan();
                    TipoDePlan.FAMILIAR.mostrarInformacionPlan();

                    do {
                        System.out.print("Ingrese el número de opción: ");
                        opcion = scanner.nextInt();

                        if ((opcion < 1 || opcion > 3)) {
                            System.out.println("Opción inválida. Intente nuevamente.");
                        }
                    } while (opcion < 1 || opcion > 3);

                    switch (opcion) {
                        case 1:
                            tipoPlan = TipoDePlan.DUO;
                            cliente.setTipoDePlan(tipoPlan);
                            break;
                        case 2:
                            tipoPlan = TipoDePlan.INDIVIDUAL;
                            cliente.setTipoDePlan(tipoPlan);
                            break;
                        case 3:
                            tipoPlan = TipoDePlan.FAMILIAR;
                            cliente.setTipoDePlan(tipoPlan);
                            break;
                    }

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

        System.out.println(Color.azul + "1. Ver mis Playlists");
        System.out.println("2. Seleccionar una Playlist");
        System.out.println("3. Cambiar a Premium");
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

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);

                    break;
                case 2:

                    //pasos para permirle crear una playlist

                    break;
                case 3:

                    // seleccionar una playlist y escucharla
                    break;
                case 4:

                   // Cliente cliente = gestionClientes.buscarClienteId(idLogueado);
                   // gestionClientes.cambiarPlan(cliente);

                    break;
                case 5:
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
        System.out.println("3. Seleccionar una Playlist");
        System.out.println("4. Quiero pasarme al plan Free");
        System.out.println(Color.amarillo + "5. Salir" + Color.b);
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }
}