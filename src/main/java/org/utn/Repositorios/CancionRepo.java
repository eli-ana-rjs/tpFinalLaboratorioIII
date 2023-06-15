package org.utn.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CancionRepo implements IRepository<Cancion> {
    public final File archivoCanciones = new File("C:\\Users\\Milagros\\Documents\\GitHub\\tpFinalLaboratorioIII\\src\\main\\java\\org\\utn\\canciones.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Cancion> listaCanciones;


    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cancion.class);
            this.listaCanciones = mapper.readValue(archivoCanciones, collectionType);
        } catch (IOException e) {
            this.listaCanciones = new ArrayList<>();
        }

    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoCanciones, this.listaCanciones);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean buscar(Cancion objeto) {
        boolean cancionEncontrada = false;
        cargar();
        for (Cancion c : this.listaCanciones) {
            if (objeto.getNombre().equals(c.getNombre()) && objeto.getArtista().equals(c.getArtista())) {
                cancionEncontrada = true;
            }
        }
        return cancionEncontrada;
    }

    @Override
    public void modificar(Cancion objeto) {

    }

    @Override
    public void eliminar(Cancion objeto) {
        cargar();
        for (Cancion c : this.listaCanciones) {
            if (objeto.getNombre().equals(c.getNombre()) && objeto.getArtista().equals(c.getArtista())) {
                this.listaCanciones.remove(objeto);
            }
        }
    }

    @Override
    public void listar () {
            cargar();
            for (Cancion c : this.listaCanciones) {
                System.out.println(c.toString());
            }
        }
    @Override
    public void agregar (Cancion objeto){
            cargar();
            this.listaCanciones.add(objeto);
            guardar();
        }
    }

