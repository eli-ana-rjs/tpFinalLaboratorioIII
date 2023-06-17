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


//region OVerrides
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

    public void modificarNombreCancion(Cancion objeto, String nombre) {
        cargar();

        for(Cancion c : this.listaCanciones){
            if(objeto.getNombre().equals(c.getNombre()) && objeto.getArtista().equals(c.getArtista())){
                c.setNombre(nombre);
            }
        }
        guardar();
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
    public List<Cancion> listar() {
        return null;
    }

    @Override
    public void agregar (Cancion ... objeto){

        }

//endregion
    }

