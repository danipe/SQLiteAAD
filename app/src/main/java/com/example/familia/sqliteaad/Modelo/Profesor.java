package com.example.familia.sqliteaad.Modelo;

/**
 * Created by yo on 15/12/2017.
 */

public class Profesor {
    private String nombre, ciclo, curso, despacho;
    private int edad;

    public Profesor(String nombre, String ciclo, String curso, String despacho, int edad) {
        this.nombre=nombre;
        this.ciclo=ciclo;
        this.curso=curso;
        this.despacho=despacho;
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

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
