package com.cursojava.cliente.serviceinterface;
import com.cursojava.cliente.model.Formacion;
import com.cursojava.cliente.service.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FormacionServiceInterface implements FormacionService {

    @Autowired
    private RestTemplate restTemplate; // Necesitarás configurar un RestTemplate en tu aplicación

    private static final String CURSOS_URL = "http://localhost:8080/cursos";

    @Override
    public List<Formacion> obtenerCursos() {
        List<Formacion> cursos = restTemplate.getForObject(
                CURSOS_URL,
                List.class);
        return cursos;
    }

    @Override
    public Formacion crearFormacion(Formacion formacion) {
        Formacion nuevaFormacion = restTemplate.postForObject(
                CURSOS_URL,
                formacion,
                Formacion.class);
        return nuevaFormacion;
    }
}
