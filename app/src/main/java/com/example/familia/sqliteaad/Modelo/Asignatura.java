package com.example.familia.sqliteaad.Modelo;

/**
 * Created by yo on 22/01/2018.
 */

public class Asignatura {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    private int horas;

    public Asignatura( String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }


}
