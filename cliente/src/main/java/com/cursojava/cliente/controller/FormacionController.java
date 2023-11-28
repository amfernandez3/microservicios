package com.cursojava.cliente.controller;

import com.cursojava.cliente.model.CursoDTO;
import com.cursojava.cliente.model.Formacion;
import com.cursojava.cliente.service.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formaciones")
public class FormacionController {

    @Autowired
    private FormacionService formacionService;

    // Endpoint para obtener la lista de cursos desde el otro microservicio
    @GetMapping("/cursos")
    public ResponseEntity<List<CursoDTO>> obtenerCursos() {
        List<CursoDTO> cursos = formacionService.obtenerCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // Endpoint para añadir un nuevo curso a través del otro microservicio
    @PostMapping("/altaCurso")
    public ResponseEntity<CursoDTO> altaCurso(@RequestBody Formacion formacion) {
        CursoDTO nuevoCursoDTO = formacionService.crearFormacion(formacion);
        return new ResponseEntity<>(nuevoCursoDTO, HttpStatus.CREATED);
    }
}
