package com.cursojava.cursos.model;

public class CursoDTO {
    private String codigoCurso;
    private String nombreCurso;
    private int duracionCurso;
    private double precioCurso;
    private int asignaturas; // Nuevo atributo para el número de asignaturas

    // Constructores, getters y setters

    public CursoDTO() {
    }

    public CursoDTO(String nombreCurso, int duracionCurso, double precioCurso, int asignaturas) {
        this.nombreCurso = nombreCurso;
        this.duracionCurso = duracionCurso;
        this.precioCurso = precioCurso;
        this.asignaturas = asignaturas;
    }

    public CursoDTO(String codigoCurso, String nombreCurso, int duracionCurso, double precioCurso) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.duracionCurso = duracionCurso;
        this.precioCurso = precioCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(int duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public double getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(double precioCurso) {
        this.precioCurso = precioCurso;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    // Otros métodos si es necesario
}
