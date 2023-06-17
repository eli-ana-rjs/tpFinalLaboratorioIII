package org.utn.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPrivadaRepo implements IRepository<Playlist> {

    public final File archivoPlaylistPrivada= new File("C:\\Users\\Milagros\\Documents\\GitHub\\tpFinalLaboratorioIII\\src\\main\\java\\org\\utn\\playlistsPrivadas.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Playlist> listaPlaylistPrivada;


//region Overrides
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cancion.class);
            this.listaPlaylistPrivada = mapper.readValue(archivoPlaylistPrivada, collectionType);
        } catch(IOException e){
            this.listaPlaylistPrivada = new ArrayList<>();
        }
    }


    @Override
    public void guardar() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoPlaylistPrivada, this.listaPlaylistPrivada);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean buscar(Playlist objeto) {
        return false;
    }

    @Override
    public void modificar(Playlist objeto) {

    }

    @Override
    public void eliminar(Playlist objeto) {

    }

    @Override
    public List<Playlist> listar() {
        return null;
    }

    @Override
    public void agregar(Playlist...objeto) {

    }

    //endregion
}
