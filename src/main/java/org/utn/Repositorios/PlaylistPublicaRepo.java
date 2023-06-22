package org.utn.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import org.utn.Models.PlaylistPrivada;
import org.utn.Models.PlaylistPublica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPublicaRepo implements IRepository<PlaylistPublica> {

    public final File archivoPlaylistPublica= new File("src\\main\\java\\org\\utn\\Archivos\\playlistPublica.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<PlaylistPublica> listaPlaylistPublica;


    //region Overrides
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PlaylistPublica.class);
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
    public void agregar(PlaylistPublica... objeto) {
        cargar();
        this.listaPlaylistPublica.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public List<PlaylistPublica> listar() {
        cargar();
        return this.listaPlaylistPublica;
    }

    @Override
    public boolean buscar(PlaylistPublica objeto) {
        return false;
    }

    @Override
    public void modificar(PlaylistPublica objeto) {
        cargar();
        for (PlaylistPublica playlistPub : listaPlaylistPublica){
            if (playlistPub.equals(objeto)){
                playlistPub.setNombre(objeto.getNombre());
                playlistPub.setListaCanciones(objeto.getListaCanciones());
                break;
            }
        }
        guardar();
    }

    @Override
    public void eliminar(PlaylistPublica objeto) {
        cargar();
        for (PlaylistPublica playlistPublica : this.listaPlaylistPublica) {
            if (listaPlaylistPublica.equals(objeto)) {
                this.listaPlaylistPublica.remove(playlistPublica);
                break;
            }
        }
        guardar();
    }
//endregion
}
