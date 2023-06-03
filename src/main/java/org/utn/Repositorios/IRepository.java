package org.utn.Repositorios;

public interface IRepository<T> {

    void cargar();
    void guardar();

    void buscar();
    void modificar();
    void eliminar();
    void listar();
    void agregar();

}
