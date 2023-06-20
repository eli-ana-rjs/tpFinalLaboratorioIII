package org.utn.Models;
import org.utn.Repositorios.CancionRepo;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Milagros Pecar
 * @version 1.0
 */
public class GestionCancion {
    /**
     * Constante PI
     */
    CancionRepo repo = new CancionRepo();
    /**
     * Constante PI
     */
    Scanner scan = new Scanner(System.in);
    /**
     * Constante PI
     */
    Scanner scanString = new Scanner(System.in);

//region Metodos

    /**
     * Menu que permite buscar canciones segun su nombre, album, artista o genero
     */
    public void menuBusquedaCanciones() {

        int eleccion, salir = 0;
        String datoIngresado;

        do {
            try {
                System.out.println("<< Busqueda de canciones >>");
                imprimirLineas();
                System.out.println("1- Nombre");
                System.out.println("2- Album");
                System.out.println("3- Artista");
                System.out.println("4- Genero");
                imprimirLineas();
                eleccion = scan.nextInt();

                switch (eleccion) {
                    case 1:
                        System.out.println("Ingrese el nombre de la cancion");
                        datoIngresado = scanString.nextLine();
                        mostrarPorNombre(datoIngresado);
                        break;

                    case 2:
                        System.out.println("Ingrese el nombre del album");
                        datoIngresado = scanString.nextLine();
                        mostrarPorAlbum(datoIngresado);
                        break;

                    case 3:
                        System.out.println("Ingrese el nombre del artista");
                        datoIngresado = scanString.nextLine();
                        mostrarPorArtista(datoIngresado);

                        break;

                    case 4:
                        System.out.println("Ingrese el genero");
                        datoIngresado = scanString.nextLine();
                        mostrarPorGenero(datoIngresado);

                        break;

                    default:
                        System.out.println("Opcion no validad. Vuelva a intentarlo");
                        break;
                }

                System.out.println("Desea volver al menu de busqueda? Presione 0 para salir o cualquier otro numero para continuar");
                salir = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Ingrese una opcion valida"); //volver a menu
            }finally{
                scan.close();
                scanString.close();
            }
        } while (salir != 0);
    }

    /**
     * Muestra todas las canciones de una lista
     */
    public void mostrarTodas(){
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        if (listaCanciones != null){
            for (Cancion c : listaCanciones){
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Muestra una cancion
     * @param cancion de clase Cancion
     */
    public void mostrarUnaCancion(Cancion cancion){

        System.out.println(cancion.toString());
    }

    /**
     * Muestra canciones segun el nombre pasado por parametro
     * @param nombre de tipo String
     */
    public void mostrarPorNombre(String nombre) {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            if(c.getNombre().equalsIgnoreCase(nombre)){
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Muestra canciones segun el artista pasado por parametro
     * @param artista de tipo String
     */
    public void mostrarPorArtista(String artista) {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            if(c.getArtista().equalsIgnoreCase(artista)){
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Muestra canciones segun el album pasado por parametro
     * @param album de tipo String
     */
    public void mostrarPorAlbum(String album) {
        repo.cargar();
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            if(c.getAlbum().equalsIgnoreCase(album)){
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Muestra canciones segun el nombre pasado por parametro
     * @param generoBusqueda de tipo String
     */
    public void mostrarPorGenero(String generoBusqueda) {
        repo.cargar();
        String genero;
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion c : listaCanciones) {
            genero = devolverGeneroString(c);
            if(generoBusqueda.equalsIgnoreCase(genero)){
                mostrarUnaCancion(c);
            }
        }
    }

    /**
     * Metodo que devuelve el genero de una cancion de tipo String
     * @param c de tipo Cancion
     * @return retorna el genero de una cancion en formato String
     */
    public String devolverGeneroString(Cancion c){
        String generoString = "";

        if(c.getGenero().equals(GeneroCancion.KPOP)) {
            generoString = "Kpop";
        } else if (c.getGenero().equals(GeneroCancion.POP)) {
            generoString = "Pop";
        } else if (c.getGenero().equals(GeneroCancion.REGGAETON)) {
            generoString = "Reggaeton";
        } else if (c.getGenero().equals(GeneroCancion.METAL)) {
            generoString = "Metal";
        } else if (c.getGenero().equals(GeneroCancion.RAP)) {
            generoString = "Rap";
        } else if (c.getGenero().equals(GeneroCancion.ROCK)){
            generoString = "Rock";
        }
        return generoString;
    }

    /**
     * Agrega x cantidad de canciones
     * @param c de tipo cancion
     */
    public void agregarCanciones(Cancion...c){

        repo.agregar(c);
    }

    /**
     * Menu para agregar canciones por teclado
     */
    public void agregarCancionPorTeclado(){

        int salir, ultimoID, eleccion;
        Cancion nuevaCancion = new Cancion();
        System.out.println("<< Biblioteca de canciones >>");
        imprimirLineas();
        mostrarTodas();
        imprimirLineas();

        try {
            do {
                System.out.println("1- Agregar canciones");
                System.out.println("2- Salir");
                eleccion = scan.nextInt();
                switch(eleccion) {

                    case 1:

                        System.out.println("1- Ingrese el nombre de la cancion");
                        nuevaCancion.setNombre(scanString.nextLine());
                        System.out.println("2- Ingrese el nombre del artista");
                        nuevaCancion.setArtista(scanString.nextLine());
                        System.out.println("3- Ingrese el nombre del album");
                        nuevaCancion.setAlbum(scanString.nextLine());
                        System.out.println("4- Ingrese el genero: Kpop, Metal, Pop, Rap, Reggaeton o Rock");
                        String genero = scanString.nextLine();
                        seteoGenero(nuevaCancion, genero);
                        System.out.println("5- Ingrese la duracion");
                        nuevaCancion.setDuracion(scanString.nextLine());
                        System.out.println("6- Ingrese comentarios");
                        nuevaCancion.setComentarios(scanString.nextLine());
                        ultimoID = repo.buscarUltimoID() + 1;
                        nuevaCancion.setIdCancion(ultimoID);
                        repo.agregar(nuevaCancion);

                        break;

                    default:
                        System.out.println("Opcion no validad. Vuelva a intentarlo");
                        break;
                }
                System.out.println("Desea seguir agregando canciones? Presione 0 para salir o cualquier otro numero para continuar");
                salir = scan.nextInt();

            }while(salir != 0);

        } catch(InputMismatchException e){

            System.out.println("Ingrese un dato correcto");    //volver menu ppal

        }finally{

            scan.close();
            scanString.close();
        }

    }

    /**
     * Elimina una cancion
     * @param c de tipo Cancion
     */
    public void eliminarCancion(Cancion c){

        repo.eliminar(c);
    }

    /**
     * Busca una cancion
     * @param c de tipo Cancion
     * @return retorna true si encuentra la cancion, false si no la encuentra
     */
    public boolean buscarCancion(Cancion c){
        boolean encontrar = false;
        repo.buscar(c);

        return encontrar;
    }

    /**
     * Menu para modificar una cancion por teclado
     */
    public void modificarCancion() { //El scanner no me toma cuando separo las palabras
        repo.cargar();
        mostrarTodas();
        Cancion cancionModificada = new Cancion();
        int eleccion, cancionElegida;
        int salir = 0;
        do {
            try {

                System.out.println("Ingrese el ID de la cancion a modificar");
                cancionElegida = scan.nextInt();
                cancionModificada = repo.buscaCancionPorID(cancionElegida);

                System.out.println("Ingrese el numero del dato a cambiar");
                System.out.println("1- Nombre");
                System.out.println("2- Artista");
                System.out.println("3- Album");
                System.out.println("3- Album");
                System.out.println("4- Genero");
                System.out.println("5- Duracion");
                System.out.println("6- Comentarios");

                eleccion = scan.nextInt();

                switch (eleccion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        cancionModificada.setNombre(scanString.nextLine());
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo artista");
                        cancionModificada.setArtista(scanString.nextLine());
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo nombre del album");
                        cancionModificada.setAlbum(scanString.nextLine());
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo genero");
                        String genero = scanString.nextLine();
                        seteoGenero(cancionModificada, genero);
                        break;
                    case 5:
                        System.out.println("Ingrese la nueva duracion");
                        cancionModificada.setDuracion(scanString.nextLine());
                        break;

                    case 6:
                        System.out.println("Ingrese comentarios");
                        cancionModificada.setComentarios(scanString.nextLine());
                        break;

                    default:
                        System.out.println("Opcion no validad. Vuelva a intentarlo");
                        break;
                }
                System.out.println("Desea seguir modificando datos? Presione 0 para salir o cualquier otro numero para continuar");
                salir = scan.nextInt();
                repo.modificar(cancionModificada);
            }catch(InputMismatchException e){
                System.out.println("Ingrese un dato correcto");    //volver menu ppal
            }
        }while(salir != 0);

        scan.close();
        scanString.close();
    }

    /**
     * Busca el id de la ultima cancion agregada a un archivo
     * @return
     */
    public int buscarUltimoID(){

        return repo.buscarUltimoID();
    }

    /**
     * Setea el genero de una cancion
     * @param c de tipo Cancion
     * @param genero de tipo String
     */

    /**Busca por id una cancion y retorna la Cancion
     *
     */
    public Cancion existe(int id){
        List<Cancion> listaCanciones = repo.listar();
        for (Cancion cancion : listaCanciones){
            if (cancion.getIdCancion() == id){
                return cancion;
            }
        }
        return null;
    }

    /**Busca por id una cancion y la retorna si existe. Recibe una lista de canciones por parametro
     *
     * @param id
     * @param listaCancionesUser
     * @return
     */
    public Cancion existeEnPlaylist (int id, List<Cancion> listaCancionesUser){
        for (Cancion cancion : listaCancionesUser){
            if (cancion.getIdCancion() == id){
                return cancion;
            }
        }
        return null;
    }
    public void seteoGenero(Cancion c, String genero){

        if(genero.equalsIgnoreCase("Rock")) {
            c.setGenero(GeneroCancion.ROCK);
        } else if (genero.equalsIgnoreCase("Pop")) {
            c.setGenero(GeneroCancion.POP);
        } else if (genero.equalsIgnoreCase("Kpop")) {
            c.setGenero(GeneroCancion.KPOP);
        } else if (genero.equalsIgnoreCase("Reggaeton")) {
            c.setGenero(GeneroCancion.REGGAETON);
        } else if (genero.equalsIgnoreCase("Rap")) {
            c.setGenero(GeneroCancion.RAP);
        } else if (genero.equalsIgnoreCase("Metal")) {
            c.setGenero(GeneroCancion.METAL);
        }
        repo.setearGenero(c);
    }

    /**
     * Imprime linea de separacion
     */
    public void imprimirLineas(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

//endregion
}
