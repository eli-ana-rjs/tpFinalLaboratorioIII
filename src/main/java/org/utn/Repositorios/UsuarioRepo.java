package org.utn.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.utn.Models.Usuario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioRepo implements IRepository<Usuario> {

    private final File archivo = new File("/Users/elianaanabellarojas/IdeaProjects/tpFinalLaboratorioIII/src/main/java/org/utn/Archivos/usuarios.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Usuario> listaUsuarios;

    @Override

    public void cargarJson() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Usuario.class);
            this.listaUsuarios = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaUsuarios = new ArrayList<>();
        }
    }

    @Override
    public void guardarJson() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaUsuarios);
        } catch(IOException e){
                throw new RuntimeException("No se pudo guardar el archivo", e);
            }
        }


        @Override
        public List<Usuario> listar () {
            cargarJson();
            return this.listaUsuarios;
        }


        @Override
        public void eliminar (Usuario objeto){

        }


        @Override
        public void agregar (Usuario objeto){


        }
    }