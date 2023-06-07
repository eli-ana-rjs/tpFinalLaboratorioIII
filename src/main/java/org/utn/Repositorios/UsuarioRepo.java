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

        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar el archivo", e);
        }
    }

        @Override
        public void agregar (Usuario...obj){

            cargarJson();
            this.listaUsuarios.addAll(List.of(obj));
            guardarJson();

        }

        @Override
        public boolean buscar ( int idUsuario){
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getIdUsuario() == idUsuario) {
                    return true;
                }
            }
            System.out.println("Usuario no encontrado");
            return false;
        }

        @Override
        public void verUno ( int idUsuario){
            cargarJson();
            boolean usuarioEncontrado = buscar(idUsuario);
            if (usuarioEncontrado) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getIdUsuario() == idUsuario) {
                        System.out.println(usuario);
                        return;
                    }
                }
            }
            System.out.println("Usuario no encontrado");
        }

        @Override
        public void modificar ( int idUsuario){
            cargarJson();
            for (int i = 0; i < listaUsuarios.size(); i++) {
                Usuario usuario = listaUsuarios.get(i);
                if (usuario.getIdUsuario() == idUsuario) {
                    listaUsuarios.set(i, usuario);
                    guardarJson();
                    System.out.println("Usuario modificado exitosamente");
                    return;
                }
            }
            System.out.println("Usuario no encontrado");
        }

        @Override
        public void eliminar ( int idUsuario){
            cargarJson();
            for(Usuario prod: this.listaUsuarios){

                if(prod.getIdUsuario() == idUsuario){
                    this.listaUsuarios.remove(prod);
                    break;
                }
            }
            guardarJson();
        }

        @Override
        public List<Usuario> listar () {
        cargarJson();
        return this.listaUsuarios;
        }


    }
