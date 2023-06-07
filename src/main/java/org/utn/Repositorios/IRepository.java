package org.utn.Repositorios;

public interface IRepository<T> {

    // JSON
    void cargarJson();
    void guardarJson();

    // Acciones

    void agregar();
    void verUno();
    void buscar();
    void modificar();
    void eliminar();
    // ver todos
    void listar();


}
