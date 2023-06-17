package org.utn.Repositorios;
import org.utn.Models.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepo implements IRepository<Cliente>{

    public final File archivoCanciones = new File("C:\\Users\\Milagros\\Documents\\GitHub\\tpFinalLaboratorioIII\\src\\main\\java\\org\\utn\\clientes.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Cancion> listaClientes;

//region Overrides
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivoCanciones, collectionType);
        } catch (IOException e) {
            this.listaClientes = new ArrayList<>();
        }

    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoCanciones, this.listaClientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean buscar(Cliente objeto) {
        return false;
    }

    @Override
    public void modificar(Cliente objeto) {

    }

    @Override
    public void eliminar(Cliente objeto) {

    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public void agregar(Cliente... objeto) {

    }
//endregion
}
