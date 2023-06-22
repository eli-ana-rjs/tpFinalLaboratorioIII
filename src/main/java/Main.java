import org.utn.Models.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestionClientes gestionClientes = new GestionClientes();
        int cantidadClientes = gestionClientes.idUltimoCliente();

        Cliente.setContadorId(cantidadClientes);

        iniciarApp();


    }
    public static void iniciarApp(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opcion: \n 1.Ingresar \n 2.Registrarse ");
        int opcion = scanner.nextInt();
        GestionClientes gestionClientes = new GestionClientes();
        if( opcion == 1){
            FormLogin.dibujarMenu();
        } else if (opcion == 2){
            Cliente nuevoCliente = gestionClientes.registroNuevoCliente();
            gestionClientes.agregarCliente(nuevoCliente);
        } else {
            System.out.println("Opcion incorrecta");
        }
    }

}
