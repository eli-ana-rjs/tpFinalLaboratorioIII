import org.utn.Models.Cliente;
import org.utn.Models.Genero;
import org.utn.Models.TipoDePlan;
import org.utn.Repositorios.ClienteRepo;

public class Test {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Nelson", "Gonzalez", "robert@example.com", "15-07-1995", "nelson67", "34981023", Genero.MASCULINO,"Pine Street 789", true, TipoDePlan.INDIVIDUAL );
        //System.out.println("cliente = " + cliente);

        Cliente cliente2 = new Cliente("Ana", "Gonzalez", "ana95@hotmail.com", "15-07-1995", "ana95", "pass3455", Genero.FEMENINO,"Calle Falsa 123", false, TipoDePlan.GRATIS );

        Cliente cliente3 = new Cliente("Jose", "Almeida", "jose-almeida@hotmail.com", "23-04-1967", "jose67", "123jose", Genero.MASCULINO,"Garay 345", false, TipoDePlan.GRATIS );

        ClienteRepo clienteRepo = new ClienteRepo();

        //clienteRepo.agregar(cliente, cliente2, cliente3); // los agrega bien
        clienteRepo.eliminar(cliente3); // me borra todo

    }

}
