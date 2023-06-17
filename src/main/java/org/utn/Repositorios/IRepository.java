package org.utn.Repositorios;
import java.util.List;

import java.util.List;

public interface IRepository<T> {

    List<T> listar();
    // Acciones

    boolean buscar(T objeto);
    void modificar(T objeto);
    void eliminar(T objeto);
    void agregar(T... objeto);

    void cargar();
    void guardar();
    // analizar que conviene? Pasar el id o el objeto



}
