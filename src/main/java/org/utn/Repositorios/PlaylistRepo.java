package org.utn.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Cancion;
import org.utn.Models.Playlist;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepo implements IRepository <Playlist> {

    public final File archivoPlaylists= new File("C:\\Users\\Milagros\\Documents\\GitHub\\tpFinalLaboratorioIII\\src\\main\\java\\org\\utn\\playlists.json");
    public final ObjectMapper mapper = new ObjectMapper();
    public List<Playlist> listaPlaylists;


    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Cancion.class);
            this.listaPlaylists = mapper.readValue(archivoPlaylists, collectionType);
        } catch(IOException e){
            this.listaPlaylists = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoPlaylists, this.listaPlaylists);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean buscar(Playlist objeto) {
    return objeto; //modificar
    }

    @Override
    public void modificar(Playlist objeto) {

    }

    @Override
    public void eliminar(Playlist objeto) {

    }

    @Override
    public void listar() {
        cargar();
        for(Playlist p : this.listaPlaylists){
            System.out.println(p.toString());
        }
    }

    @Override
    public void agregar(Playlist objeto) {
        cargar();
        this.listaPlaylists.add(objeto);
        guardar();
    }
}
