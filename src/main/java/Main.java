import org.utn.Models.*;

public class Main {

    public static void main(String[] args) {
        GestionClientes gestionClientes = new GestionClientes();
        int cantidadClientes = gestionClientes.idUltimoCliente();

        Cliente.setContadorId(cantidadClientes);

        FormLogin.dibujarMenu();

        /*
        Cliente cliente1 = new Cliente("Ana", "Gómez", "ana.gomez@example.com", "secreta123", Genero.FEMENINO, "Calle Principal, 123", true, TipoDePlan.INDIVIDUAL,"24-05-1987");
        Cliente cliente2 = new Cliente("Juan", "Pérez", "juan.perez@example.com",  "contraseña456", Genero.MASCULINO, "Avenida Central, 456", false, TipoDePlan.GRATIS, "12-12-1990");
        Cliente cliente3 = new Cliente("María", "Rodríguez", "maria.rodriguez@example.com",  "miPassword789", Genero.FEMENINO, "Calle Secundaria, 789", true, TipoDePlan.FAMILIAR, "01-01-1995");
        Cliente cliente4 = new Cliente("Carlos", "López", "carlos.lopez@example.com", "claveSegura987", Genero.MASCULINO, "Avenida Norte, 987", false, TipoDePlan.DUO, "30-11-1985");
        Cliente cliente5 = new Cliente("Laura", "Fernández", "laura.fernandez@example.com", "mipass1234", Genero.OTRO, "Calle Principal, 456", true, TipoDePlan.INDIVIDUAL, "24-05-1987");

        gestionClientes.agregarCliente(cliente1);
        gestionClientes.agregarCliente(cliente2);
        gestionClientes.agregarCliente(cliente3);
        gestionClientes.agregarCliente(cliente4);
        gestionClientes.agregarCliente(cliente5);
        */



    }

}
