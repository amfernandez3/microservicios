package com.cursojava.cliente.service;

import com.cursojava.cliente.model.CursoDTO;
import com.cursojava.cliente.model.Formacion;

import java.util.List;

public interface FormacionService {
    List<CursoDTO> obtenerCursos();
    CursoDTO crearFormacion(Formacion formacion);
}