package org.utn.Repositorios;

import java.util.List;

public interface IRepository<T> {

    // JSON
    void cargarJson();
    void guardarJson();

    List<T> listar();
    // Acciones

    boolean buscar(T objeto);
    void modificar(T objeto);
    void eliminar(T objeto);
    void agregar(T objeto);


}
