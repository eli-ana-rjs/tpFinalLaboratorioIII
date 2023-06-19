package org.utn.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import org.utn.Models.PlaylistPublica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPublicaRepo implements IRepository<Playlist> {

    public final File archivoPlaylistPublica= new File("C:\\Users\\Milagros\\Documents\\GitHub\\tpFinalLaboratorioIII\\src\\main\\java\\org\\utn\\playlistsPublicas.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Playlist> listaPlaylistPublica;


//region Overrides
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cancion.class);
            this.listaPlaylistPublica = mapper.readValue(archivoPlaylistPublica, collectionType);
        } catch(IOException e){
            this.listaPlaylistPublica = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoPlaylistPublica, this.listaPlaylistPublica);
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
    public void agregar(Playlist... objeto) {

    }
//endregion
}
