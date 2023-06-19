import org.utn.Models.*;

public class Main {

    public static void main(String[] args) {
        GestionClientes gestionClientes = new GestionClientes();
        int cantidadClientes = gestionClientes.idUltimoCliente();

        Cliente.setContadorId(cantidadClientes);

        // FormLogin.dibujarMenu();

        /*
        Cliente cliente1 = new Cliente("Ana", "Gómez", "ana.gomez@example.com", "secreta123", Genero.FEMENINO, "Calle Principal, 123", true, TipoDePlan.INDIVIDUAL);
        Cliente cliente2 = new Cliente("Juan", "Pérez", "juan.perez@example.com",  "contraseña456", Genero.MASCULINO, "Avenida Central, 456", false, TipoDePlan.GRATIS);
        Cliente cliente3 = new Cliente("María", "Rodríguez", "maria.rodriguez@example.com",  "miPassword789", Genero.FEMENINO, "Calle Secundaria, 789", true, TipoDePlan.FAMILIAR);
        Cliente cliente4 = new Cliente("Carlos", "López", "carlos.lopez@example.com", "claveSegura987", Genero.MASCULINO, "Avenida Norte, 987", false, TipoDePlan.DUO);
        Cliente cliente5 = new Cliente("Laura", "Fernández", "laura.fernandez@example.com", "mipass1234", Genero.OTRO, "Calle Principal, 456", true, TipoDePlan.INDIVIDUAL);

        gestionClientes.agregarCliente(cliente1);
        gestionClientes.agregarCliente(cliente2);
        gestionClientes.agregarCliente(cliente3);
        gestionClientes.agregarCliente(cliente4);
        gestionClientes.agregarCliente(cliente5);
        */



    }

}
