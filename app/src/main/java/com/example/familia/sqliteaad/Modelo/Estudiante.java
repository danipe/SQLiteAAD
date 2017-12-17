package com.example.familia.sqliteaad.Modelo;

/**
 * Created by yo on 15/12/2017.
 */

public class Estudiante {
    private String nombre, ciclo, curso;
    private int edad, nota;

    public Estudiante(String nombre, String ciclo, String curso, int nota, int edad) {
        this.nombre=nombre;
        this.ciclo=ciclo;
        this.curso=curso;
        this.nota=nota;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
