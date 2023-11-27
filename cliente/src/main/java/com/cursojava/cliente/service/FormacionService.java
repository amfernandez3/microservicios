package com.cursojava.cliente.service;

import com.cursojava.cliente.model.Formacion;

import java.util.List;

public interface FormacionService {
    List<Formacion> obtenerCursos();
    Formacion crearFormacion(Formacion formacion);
}