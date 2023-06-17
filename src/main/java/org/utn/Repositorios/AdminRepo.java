package org.utn.Repositorios;
import org.utn.Models.Administrador;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepo implements IRepository<Administrador> {

    public final File archivoPlaylistPublica= new File("C:\\Users\\Milagros\\Documents\\GitHub\\tpFinalLaboratorioIII\\src\\main\\java\\org\\utn\\administradores.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Playlist> listaAdministradores;

//region OVerrides
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Administrador.class);
            this.listaAdministradores = mapper.readValue(archivoPlaylistPublica, collectionType);
        } catch(IOException e){
            this.listaAdministradores= new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoPlaylistPublica, this.listaAdministradores);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean buscar(Administrador objeto) {
        return false;
    }

    @Override
    public void modificar(Administrador objeto) {

    }
    @Override
    public void eliminar(Administrador objeto) {

    }
    @Override
    public List<Administrador> listar() {
        return null;
    }

    @Override
    public void agregar(Administrador... objeto) {

    }

    //endregion
}
