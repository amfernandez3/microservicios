package com.cursojava.cursos.DAO;

import com.cursojava.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoDAO extends JpaRepository<Curso,Integer> {
    /**
     * Permite la busqueda de los cursos entre dos valores de precio
     * @param precioMinimo precio mínimo del curso
     * @param precioMaximo precio máximo del curso
     * @return devuelve la lista de cursos que cumplen la condición
     */
    List<Curso> findByPrecioCursoBetween(int precioMinimo, int precioMaximo);

    /**
     * Permite la busqueda de los cursos por duración entre dos valores
     * @param horasMinimo define el minimo de horas
     * @param horasMaximo define el máximo de horas
     * @return devuelve la lista de cursos que cumplen la condición
     */
    List<Curso> findByDuracionCursoBetween(int horasMinimo, int horasMaximo);

    List<Curso> findByNombreCursoContaining(String nombre);
}
