package org.utn.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import org.utn.Models.PlaylistPrivada;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistPrivadaRepo implements IRepository<PlaylistPrivada> {

    public final File archivoPlaylistPrivada= new File("src\\main\\java\\org\\utn\\Archivos\\playlistPrivada.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<PlaylistPrivada> listaPlaylistPrivada;


    //region Overrides

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PlaylistPrivada.class);
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
    public void agregar(PlaylistPrivada... objeto) {
        cargar();
        this.listaPlaylistPrivada.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public List<PlaylistPrivada> listar() {
        cargar();
        return this.listaPlaylistPrivada;
    }

    @Override
    public boolean buscar(PlaylistPrivada objeto) {
        return false;
    }

    @Override
    public void modificar(PlaylistPrivada objeto) {
        cargar();
        for (Playlist playlistPriv : listaPlaylistPrivada){
            if (playlistPriv.equals(objeto)){
                playlistPriv.setNombre(objeto.getNombre());
                playlistPriv.setListaCanciones(objeto.getListaCanciones());
                break;
            }
        }
        guardar();
    }

    @Override
    public void eliminar(PlaylistPrivada objeto) {
        cargar();
        for (Playlist playlistPrivada : this.listaPlaylistPrivada) {
            if (listaPlaylistPrivada.equals(objeto)) {
                this.listaPlaylistPrivada.remove(playlistPrivada);
                break;
            }
        }
        guardar();
    }
    //endregion

}
