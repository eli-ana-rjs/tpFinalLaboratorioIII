package org.utn.Repositorios;

import java.util.List;

public interface IRepository<T> {

    // JSON
    void cargarJson();
    void guardarJson();

    List<T> listar();
    // Acciones

    void agregar(T... obj);
    void verUno(int id);
    boolean buscar(int id);
    void modificar(int id);
    void eliminar(int id);



}
