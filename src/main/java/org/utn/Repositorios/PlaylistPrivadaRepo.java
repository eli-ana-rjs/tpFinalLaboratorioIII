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

public class PlaylistPrivadaRepo implements IRepository<Playlist> {

    public final File archivoPlaylistPrivada= new File("src\\main\\java\\org\\utn\\Archivos\\playlistPrivada.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Playlist> listaPlaylistPrivada;


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
    public boolean buscar(Playlist objeto) {
        return false;
    }

    @Override
    public void modificar(Playlist objeto) {
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
    public void eliminar(Playlist objeto) {
        cargar();
        for (Playlist playlistPrivada : this.listaPlaylistPrivada) {
            if (listaPlaylistPrivada.equals(objeto)) {
                this.listaPlaylistPrivada.remove(playlistPrivada);
                break;
            }
        }
        guardar();
    }

    @Override
    public List<Playlist> listar() {
        cargar();
        return this.listaPlaylistPrivada;
    }

    @Override
    public void agregar(Playlist... objeto) {
        cargar();
        this.listaPlaylistPrivada.addAll(List.of(objeto));
        guardar();
    }


    //endregion
}
