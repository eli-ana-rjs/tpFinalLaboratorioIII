package org.utn.Menu;

import org.utn.Models.*;
import org.utn.Utilidades.Color;
import java.util.Scanner;
import static org.utn.Utilidades.Utilidades.dibujarRectanguloTexto;

/**
 * Esta clase se encarga de dibujar el menu de administrador y de llamar a los metodos de las clases que se encargan de la gestion de clientes, administradores y canciones
 * @author Eliana Rojas
 *
 */
public class MenuAdmin {

    /**
     * Muestra el menu principal del administrador y lo inicia
     */
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

    /**
     * Metodo que se encarga de mostrar las opciones del menu princiapal de un administrador
     */
    public void mostrarMenuPrincipal() {

        String titulo = "Menu Principal";
        dibujarRectanguloTexto(titulo);

        System.out.println(Color.azul + "1. Gestion Clientes");
        System.out.println(Color.magenta + "2. Gestion Administradores");
        System.out.println(Color.verde + "3. Gestion Canciones");
        System.out.println("4. Crear una playlist publica");
        System.out.println(Color.amarillo + "5. Salir");
        System.out.print(Color.rojo + "Elige una opción: \n" + Color.b);
    }

    /**
     * Metodo que se encarga de mostrar las acciones que puede realizar el administrador en el submenu Gestion Clientes
     * @param opcion  opcion elegida por el administrador
     */
    public void mostrarSubMenuClientes(String opcion) {

        String titulo = " Submenú de " + opcion ;
        dibujarRectanguloTexto(titulo);
        System.out.println("\n");

        System.out.println("1. Dar de alta un Cliente ");
        System.out.println("2. Modificar datos de un cliente "); // falta testear
        System.out.println("3. Dar de baja un Cliente ");
        System.out.println("4. Listar todos los Clientes ");
        System.out.println("5. Listar todos los Clientes Free ");
        System.out.println("6. Listar todos los Clientes Premium ");
        System.out.println("7. Volver al menú principal ");
        System.out.print("Elige una opción: ");
    }

    /**
     * Metodo que se encarga de mostrar las acciones que puede realizar el administrador en el submenu Gestion Administrador
     * @param opcion opcion elegida por el administrador
     */
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

    /**
     * Metodo que se encarga de mostrar las acciones que puede realizar el administrador en el submenu Gestion Canciones
     * @param opcion opcion elegida por el administrador
     */
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

    /**
     * Metodo que se encarga de mostrar las opciones del submenu de Gestion Playlists Publicas
     * @param opcion opcion elegida por el administrador
     */
    public void mostrarSubMenuPlaylistPublica(String opcion){
        String titulo = "Submenu de " + opcion;
        dibujarRectanguloTexto(titulo);

        System.out.println("1. Crear playlist Publica");
        System.out.println("2. Mostrar Playlists Publicas");
        System.out.println("3. Modificar una Playlist Publica");
        System.out.println("4. Dar de baja una Playlist Publica");
    }

    /**
     * Este metodo se encarga de manejar las opciones del submenu de  gestionClientes
     * @param opcionSubMenuClientes opcion elegida por el administrador
     */
    public void manejarOpcionSubMenuClientes(int opcionSubMenuClientes) {

        GestionClientes gestionClientes = new GestionClientes();
        switch (opcionSubMenuClientes) {

            case 1:

                Cliente cliente = gestionClientes.pedirDatosCliente();
                gestionClientes.agregarCliente(cliente);
                break;
            case 2:
                Cliente clienteModificado = gestionClientes.pedirDatosCliente();
                gestionClientes.modificarCliente(clienteModificado);

                break;
            case 3:

                Cliente bajaCliente = gestionClientes.buscarClienteId(2);
                System.out.println(bajaCliente);
                gestionClientes.eliminarCliente(bajaCliente);

                break;
            case 4:

                gestionClientes.mostrarClientes();
                break;
            case 5:

                gestionClientes.listarClientesFree();

                break;
            case 6:

                gestionClientes.listarClientesPremium();
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }

    /**
     * Este metodo se encarga de manejar las opciones del submenu de  gestionAdministradores
     * @param opcionSubMenuAdministradores opcion elegida por el administrador
     */
    public void manejarOpcionSubMenuAdministradores(int opcionSubMenuAdministradores) {
        GestionClientes gestionCliente = new GestionClientes();
        switch (opcionSubMenuAdministradores) {
            case 1:
                System.out.println("Dando de alta un admin ");
                break;
            case 2:
                System.out.println("Modificando datos de un administrador...");
                break;
            case 3:
                System.out.println("Dando de baja un admin...");
                break;
            case 4:
                gestionCliente.listarAdministradores();
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }

    /**
     *
     * @param opcionSubMenuCanciones
     */
    public void manejarOpcionSubMenuCanciones(int opcionSubMenuCanciones) {

        GestionCancion gestionCancion = new GestionCancion();
        Scanner scanner = new Scanner(System.in);

        switch (opcionSubMenuCanciones) {
            case 1:
                System.out.println("Dando de alta una cancion...");
                gestionCancion.agregarCancionPorTeclado();
                break;
            case 2:
                System.out.println("Modificando datos de una cancion");
                gestionCancion.modificarCancion();
                break;
            case 3:
                System.out.println("Dar de baja una cancion...");
                System.out.println("Ingrese el id de la cancion que desea eliminar: ");
                int idCancionEliminar = scanner.nextInt();
                Cancion cancionEliminar = gestionCancion.buscarPorID(idCancionEliminar);
                gestionCancion.eliminarCancion(cancionEliminar);
                break;
            case 4:
                System.out.println("Listado de canciones...");
                gestionCancion.mostrarTodas();
                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }

    // ver que cosas se hacen con las playlists

    /**
     *
     * @param opcionSubMenuPlaylists
     */
    public void manejarOpcionSubMenuPlaylists(int opcionSubMenuPlaylists){

        GestionPlaylistPublica gestionPlaylistPublica = new GestionPlaylistPublica();
        PlaylistPublica playlistPublica = new PlaylistPublica();

        switch (opcionSubMenuPlaylists) {
            case 1:
                System.out.println("Crear Playlist Publica...");
                gestionPlaylistPublica.crearPlaylistPublica(playlistPublica);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción inválida. Introduce un número válido.");
                break;
        }
    }
}