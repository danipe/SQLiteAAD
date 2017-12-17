package com.example.familia.sqliteaad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Profesores extends AppCompatActivity {
    EditText nombre, edad, ciclo, curso, despacho, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        this.nombre = (EditText) findViewById(R.id.nombre);
        this.edad = (EditText) findViewById(R.id.edad);
        this.ciclo = (EditText) findViewById(R.id.ciclo);
        this.curso = (EditText) findViewById(R.id.curso);
        this.despacho = (EditText) findViewById(R.id.despacho);
        this.id = (EditText) findViewById(R.id.id);
    }

    public void reestablecerProfesor(View v) {
        this.nombre.setText("");
        this.edad.setText("");
        this.ciclo.setText("");
        this.curso.setText("");
        this.despacho.setText("");
    }

    public void insertarProfesor(View v) {
        MainActivity.myDBAdapter.insertarProfesor(
                this.nombre.getText().toString(),
                this.ciclo.getText().toString(),
                this.curso.getText().toString(),
                Integer.parseInt(this.edad.getText().toString()),
                this.despacho.getText().toString());
    }

    public void eliminarProfesor(View v) {
        MainActivity.myDBAdapter.eliminarEstudiante(Integer.parseInt(this.id.getText().toString()));
    }
}
