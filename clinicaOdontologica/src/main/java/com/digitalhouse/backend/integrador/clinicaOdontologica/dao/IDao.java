package com.digitalhouse.backend.integrador.clinicaOdontologica.dao;

import java.util.List;

public interface IDao<T> {
    //alta, buscarlos, eliminarlos y listarlos
    T registrar(T t);

    T buscarPorId(Long id);

    void eliminar(Long id);

    List<T> listarTodos();

    T modificar(T t);
}
