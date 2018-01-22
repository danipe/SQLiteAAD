package com.example.familia.sqliteaad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.familia.sqliteaad.Modelo.Asignatura;

public class MainActivity extends AppCompatActivity {


    public static MyDBAdapter myDBAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myDBAdapter = new MyDBAdapter(getApplicationContext());
    }

    public void estudiantes(View v) {
        Intent i = new Intent(this,Estudiantes.class);
        startActivity(i);
    }

    public void mostrarEstudiantes(View v) {
        Intent i = new Intent(this,ConsultaEstudiantes.class);
        startActivity(i);
    }

    public void profesores(View v) {
        Intent i = new Intent(this,Profesores.class);
        startActivity(i);
    }

    public void mostrarProfesores(View v) {
        Intent i = new Intent(this,ConsultaProfesores.class);
        startActivity(i);
    }

    public void asignaturas(View v) {
        Intent i = new Intent(this,Asignaturas.class);
        startActivity(i);
    }

    public void mostrarAsignaturas(View v) {
        Intent i = new Intent(this,ConsultaAsignatura.class);
        startActivity(i);
    }

    public void eliminarBD(View v) {
        this.myDBAdapter.eliminarDB();
    }
}
