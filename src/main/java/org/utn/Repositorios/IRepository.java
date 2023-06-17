package org.utn.Repositorios;
import java.util.List;

import java.util.List;

public interface IRepository<T> {

<<<<<<< HEAD
    // JSON
    void cargarJson();
    void guardarJson();

    List<T> listar();
    // Acciones

    boolean buscar(T objeto);
    void modificar(T objeto);
    void eliminar(T objeto);
    void agregar(T objeto);
=======
    void cargar();
    void guardar();
    boolean buscar(T objeto);
    void modificar(T objeto);
    void eliminar(T objeto);
    List<T> listar();
    void agregar(T ... objeto);
>>>>>>> 938e6fa (Se crearon nuevas clases y metodos, se reorganizo la base del proyecto)


}
