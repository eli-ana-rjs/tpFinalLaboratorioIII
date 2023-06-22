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
    GestionPlaylistPrivada gestionPlaylistPrivada = new GestionPlaylistPrivada();
    GestionCancion gestionCancion = new GestionCancion();

    TipoDePlan tipoPlan;

    Biblioteca biblioteca = new Biblioteca();


    public void iniciarMenuClienteFree() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {


            mostrarMenuClienteFree();
            opcion = scanner.nextInt();

            Cliente clienteLogueado = Login.getLogueado();
            int idClienteActual = clienteLogueado.getId();

            switch (opcion) {
                case 1:

                    System.out.println("Mis playlist");



                    biblioteca.mostrarBibliotecaCliente(idClienteActual);

                    break;
                case 2:

                    //Cliente clienteLogueado2 = Login.getLogueado();
                   //int idClienteActual2 = clienteLogueado2.getId();

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);
                    biblioteca.ingresoPlaylistUsuarioFree(idClienteActual);


                    break;
                case 3:

                    //Cliente clienteLogueado3 = Login.getLogueado();
                   // int idClienteActual3 = clienteLogueado3.getId();
                    Cliente cliente = gestionClientes.buscarClienteId(idClienteActual);

                    gestionClientes.cambiarPlan(cliente);
                    FormLogin.dibujarMenu();
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

        String titulo = "Bienvenido a Spoti-J - Free";
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
            Cliente clienteLogueado = Login.getLogueado();
            int idClienteActual = clienteLogueado.getId();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:




                    biblioteca.mostrarBibliotecaCliente(idClienteActual);

                    break;
                case 2:

                   // Cliente clienteLogueado2 = Login.getLogueado();
                   // int idClienteActual = clienteLogueado.getId();

                    PlaylistPrivada playlist =  biblioteca.crearPlaylistDesdeBiblioteca(idClienteActual);

                    gestionCancion.switchBusquedaCanciones();

                    // necesito saber que cancion voy a agregar y a que playlist la agrego

                    gestionPlaylistPrivada.agregarCancion(playlist);

                    biblioteca.mostrarBibliotecaCliente(idClienteActual);
                    break;
                case 3:

                  //  Cliente clienteLogueado3 = Login.getLogueado();
                  //  int idClienteActual3 = clienteLogueado3.getId();
                    biblioteca.mostrarBibliotecaCliente(idClienteActual);
                    biblioteca.escucharDesdeBiblioteca();


                    break;
                case 4:
                    biblioteca.eliminarDesdeBiblioteca();

                    break;
                case 5:
                    System.out.println("Cambiar a plan free");
                     Cliente cliente = gestionClientes.buscarClienteId(idClienteActual);
                     gestionClientes.cambiarPlan(cliente);
                    FormLogin.dibujarMenu();

                    break;
                case 6:
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
        System.out.println("2. Crear una nueva playlist");
        System.out.println("3. Seleccionar y escuchar una Playlist");
        System.out.println("4. Eliminar Playlist");
        System.out.println("5. Quiero pasarme al plan Free");
        System.out.println(Color.amarillo + "6. Salir" + Color.b);
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }
}