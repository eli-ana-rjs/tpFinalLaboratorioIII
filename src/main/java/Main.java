
import org.utn.Menu.*;
import org.utn.Models.*;
import org.utn.Repositorios.ClienteRepo;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        //dibujarLogo();

        MenuAdmin menu = new MenuAdmin();
       // menu.iniciarMenuAdmin();

        //Login login = new Login();
        //login.iniciarSesion("nelson67", "34981023");

        GestionClientes gestionClientes = new GestionClientes();
        //gestionClientes.mostrarClientes();

        Cliente cliente = new Cliente("Nelson", "Gonzalez", "robert@example.com", "15-07-1995", "nelson67", "34981023", Genero.MASCULINO,"Pine Street 789", true, TipoDePlan.INDIVIDUAL );
        //System.out.println("cliente = " + cliente);

        Cliente cliente2 = new Cliente("Ana", "Gonzalez", "robert@example.com", "15-07-1995", "ne", "34981023", Genero.MASCULINO,"Pine Street 789", true, TipoDePlan.INDIVIDUAL );

        ClienteRepo clienteRepo = new ClienteRepo();
        //clienteRepo.agregar(cliente, cliente2);

        List<Cliente> clientes = clienteRepo.listar();

        for ( Cliente c:clientes) {
            System.out.println("c = " + c);

        }

        gestionClientes.listarClientes();

    }

    public static void dibujarLogo() {
        String[] logo = {
                "                                                       ",
                "                                                       ",
                "   /////    /////     /////     //////  //         ///////     ",
                "  //       //   //   //   //     //    //               //      ",
                " /////    //   //   //   //     //    //   ////        //      ",
                "     //  /////     //   //     //    //          //   //     ",
                " /////  //         /////      //    //            /////       ",
                "                                                                          ",
                "                                                                           "
        };

        for (String linea : logo) {
            System.out.println(linea);
        }
    }

}
