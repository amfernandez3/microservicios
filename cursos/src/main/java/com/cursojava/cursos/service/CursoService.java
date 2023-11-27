package com.cursojava.cursos.service;

import com.cursojava.cursos.DAO.CursoDAO;
import com.cursojava.cursos.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoDAO cursoDAO;

    //Métodos CRUD

    /**
     * Permite crear un curso
     * @param curso
     * @return
     */
    public Curso crearCurso(Curso curso){
        return cursoDAO.save(curso);
    }

    /**
     * Permite obtener la lista de todos los cursos
     * @return
     */
    public List<Curso> obtenerCursos(){
        return cursoDAO.findAll();
    }

    /**
     * Permite eliminar un curso usando el ia
     * @param cursoId
     */
    public void eliminarCurso(int cursoId) {
        cursoDAO.deleteById(cursoId);
    }

    /**
     * Función que permite modificar los datos de un curso
     * @param cursoId
     * @param curso
     * @return
     */
    public Curso actualizarCurso(int cursoId, Curso curso) {
        Optional<Curso> cursoExistente = cursoDAO.findById(cursoId);
        if (cursoExistente.isPresent()) {
            Curso cursoEncontrado = cursoExistente.get();
            cursoEncontrado.setNombreCurso(curso.getNombreCurso());
            cursoEncontrado.setDuracionCurso(curso.getDuracionCurso());
            cursoEncontrado.setPrecioCurso(curso.getPrecioCurso());
            return cursoDAO.save(cursoEncontrado);
        } else {
            return null;
        }
    }


    //Métodos extra
    /**
     * Función que permite añadir varios cursos a la vez
     * @param cursos Recibe el objeto iterable (lista) con los datos a almacenar
     * @return devuelve la lista de cursos
     * @see Curso
     */
    public List<Curso> crearCursos (List<Curso> cursos){
        return cursoDAO.saveAll(cursos);
    }

    /**
     *
     * @param cursoId
     * @return
     */
    public Curso obtenerCurso(int cursoId) {
        return cursoDAO.findById(cursoId).orElse(null);
    }

    public List<Curso> cursosPorPrecio(int precioMaximo, int precioMinimo){
        return cursoDAO.findByPrecioCursoBetween(precioMaximo,precioMinimo);
    }

    /**
     * Crea una capa de abstracción entre el controlador y el modelo de acceso a datos.
     * @see CursoDAO
     */
    public List<Curso> cursosPorDuracion(int duracionMinima, int duracionMaxima){
        return cursoDAO.findByPrecioCursoBetween(duracionMinima, duracionMaxima);
    }


    public List<Curso> obtenerCursosPorNombre(String parteDelNombre) {
        return cursoDAO.findByNombreCursoContaining(parteDelNombre);
    }

}
