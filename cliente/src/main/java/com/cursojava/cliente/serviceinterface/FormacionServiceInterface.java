package com.cursojava.cliente.serviceinterface;
import com.cursojava.cliente.model.CursoDTO;
import com.cursojava.cliente.model.Formacion;
import com.cursojava.cliente.service.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FormacionServiceInterface implements FormacionService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CURSOS_URL = "http://localhost:8080/cursos";



    @Override
    public List<CursoDTO> obtenerCursos() {
        ResponseEntity<List<CursoDTO>> responseEntity = restTemplate.exchange(
                CURSOS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CursoDTO>>() {});

        List<CursoDTO> cursos = responseEntity.getBody();

        for (CursoDTO curso : cursos) {
            int duracionCurso = curso.getDuracionCurso();

            // Aplicar la lógica para determinar el número de asignaturas
            int numeroAsignaturas = (duracionCurso > 50) ? 10 : 5;

            // Establecer el número de asignaturas en el objeto CursoDTO
            curso.setAsignaturas(numeroAsignaturas);
        }

        return cursos;
    }



    public CursoDTO crearFormacion(Formacion formacion) {
        // Verificar si ya existe un curso con el mismo nombre (puedes implementar esta lógica según tus necesidades)
        if (existeCursoConMismoNombre(formacion.getCurso())) {
            // Puedes manejar este caso de alguna manera, por ejemplo, devolviendo null o un indicador de error
            return null;
        }

        // Calcular la duración del curso según la fórmula: asignaturas * 10
        int duracionCurso = formacion.getAsignaturas() * 10;

        // Crear un objeto CursoDTO con los datos de Formacion y la duración calculada
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNombreCurso(formacion.getCurso());
        cursoDTO.setDuracionCurso(duracionCurso);
        cursoDTO.setPrecioCurso(formacion.getPrecio());
        cursoDTO.setAsignaturas(formacion.getAsignaturas());

        // Realizar la llamada al microservicio para dar de alta el curso
        CursoDTO nuevoCursoDTO = restTemplate.postForObject(
                CURSOS_URL,
                cursoDTO,
                CursoDTO.class);

        return nuevoCursoDTO;
    }



    // Método de ejemplo para verificar si ya existe un curso con el mismo nombre
    private boolean existeCursoConMismoNombre(String nombreCurso) {
        // Lógica para verificar la existencia del curso según el nombre
        // Retorna true si ya existe, false si no
        // Puedes implementar esta lógica según tus necesidades
        // Por ejemplo, podrías hacer una llamada al microservicio de cursos para verificar la existencia
        return false;
    }

}
