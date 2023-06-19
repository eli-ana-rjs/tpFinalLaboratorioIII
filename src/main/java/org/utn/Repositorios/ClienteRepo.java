package org.utn.Repositorios;

import org.utn.Models.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepo implements IRepository<Cliente> {

    private final File archivo = new File("src/main/java/org/utn/Archivos/clientes.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Cliente> listaClientes;


    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivo, collectionType);
        } catch (Exception e) {
            System.out.println("Entre al catch de cargar()");
            System.out.println("e = " + e);
            this.listaClientes = new ArrayList<>();
        }
    }


    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaClientes);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar el archivo", e);

        }
    }

    @Override
    public void agregar(Cliente... obj) {

        cargar();
        listaClientes.addAll(List.of(obj));
        guardar();

    }

    @Override
    public boolean buscar(Cliente objeto) {
        cargar();
        for (Cliente c : this.listaClientes) {
            if (c.getId() == objeto.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void modificar(Cliente cliente) {
        cargar();

        for (Cliente c : this.listaClientes) {
            if(c.getId() == cliente.getId()){
                c.setGenero(cliente.getGenero());
                c.setDomicilio(cliente.getDomicilio());
                c.setPremium(cliente.isPremium());
                c.setTipoDePlan(cliente.getTipoDePlan());
                c.setApellido(cliente.getApellido());
                c.setNombre(cliente.getNombre());
                c.setEmail(cliente.getEmail());
                c.setFechaNacimiento(cliente.getFechaNacimiento());
                c.setUserName(cliente.getUserName());
                c.setPassword(cliente.getPassword());

                System.out.println("Usuario modificado exitosamente");
                break;
            } else {
                System.out.println("Usuario no encontrado");
            }
        }

        guardar();


    }


    public void eliminar(Cliente cliente) {
        cargar();
        for (Cliente c : this.listaClientes) {

            if (c.getId() == cliente.getId()) {
                this.listaClientes.remove(c);
                break;
            }
        }
        guardar();
    }

    @Override
    public List<Cliente> listar() {
        cargar();
        return this.listaClientes;
    }

}
