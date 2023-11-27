package com.cursojava.cursos.controller;

import com.cursojava.cursos.model.Curso;
import com.cursojava.cursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //localhost:8080/cursos (GET + JSON)
    // Crear curso
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }

    //localhost:8080/cursos (POST + json)
    // Crear varios cursos
    @PostMapping("/varios")
    public ResponseEntity<List<Curso>> crearCursos(@RequestBody List<Curso> cursos) {
        List<Curso> nuevosCursos = cursoService.crearCursos(cursos);
        return new ResponseEntity<>(nuevosCursos, HttpStatus.CREATED);
    }

    //localhost:8080/cursos (GET)
    // Obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> obtenerCursos() {
        List<Curso> cursos = cursoService.obtenerCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    //localhost:8080/cursos/10 (GET)
    // Obtener un curso por ID
    @GetMapping("/{cursoId}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable int cursoId) {
        Curso curso = cursoService.obtenerCurso(cursoId);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //localhost:8080/cursos/12 (PUT)
    // Actualizar curso por ID
    @PutMapping("/{cursoId}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable int cursoId, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.actualizarCurso(cursoId, curso);
        if (cursoActualizado != null) {
            return new ResponseEntity<>(cursoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //localhost:8080/cursos/11 (DELETE)
    // Eliminar curso por ID
    @DeleteMapping("/{cursoId}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable int cursoId) {
        cursoService.eliminarCurso(cursoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //http://localhost:8080/cursos/cursosPorPrecio?precioMinimo=250&precioMaximo=300

    /**
     * Función que permite buscar los cursos entre un rango de precio
     * @param precioMinimo
     * @param precioMaximo
     * @return
     */
    @GetMapping("/cursosPorPrecio")
    public List<Curso> getCursosPorPrecio(
            @RequestParam int precioMinimo,
            @RequestParam int precioMaximo
    ) {
        return cursoService.cursosPorPrecio(precioMinimo, precioMaximo);
    }

    //localhost:8080/cursos/actualizarDuracion/12?nuevaDuracion=50
    @PutMapping("/actualizarDuracion/{codigoCurso}")
    public void actualizarDuracion(
            @PathVariable int codigoCurso,
            @RequestParam int nuevaDuracion
    ) {
        Curso curso = cursoService.obtenerCurso(codigoCurso);
        curso.setDuracionCurso(nuevaDuracion);
        cursoService.actualizarCurso(curso.getCodigoCurso(),curso);
    }

    /**
     * Función que permite buscar cursos cuyo nombre contenda una cadena de texto
     * @param nombre
     * @return
     */
    //localhost:8080/cursos/buscar?nombre=pro
    @GetMapping("/buscar")
    public List<Curso> buscarPornombre(@RequestParam String nombre){
        return cursoService.obtenerCursosPorNombre(nombre);
    }

}
