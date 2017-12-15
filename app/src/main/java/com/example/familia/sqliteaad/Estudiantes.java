package com.example.familia.sqliteaad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class Estudiantes extends AppCompatActivity {
    EditText nombre, edad, ciclo, curso, nota, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes);
        this.nombre = (EditText) findViewById(R.id.nombre);
        this.edad = (EditText) findViewById(R.id.edad);
        this.ciclo = (EditText) findViewById(R.id.ciclo);
        this.curso = (EditText) findViewById(R.id.curso);
        this.nota = (EditText) findViewById(R.id.nota);
        this.id = (EditText) findViewById(R.id.id);
    }

    public void reestablecerEstudiante(View v) {
        this.nombre.setText("");
        this.edad.setText("");
        this.ciclo.setText("");
        this.curso.setText("");
        this.nota.setText("");
    }

    public void insertarEstudiante(View v) {
        MainActivity.myDBAdapter.insertarEstudiante(
                this.nombre.getText().toString(),
                this.ciclo.getText().toString(),
                this.curso.getText().toString(),
                Integer.parseInt(this.edad.getText().toString()),
                Integer.parseInt(this.nota.getText().toString()));
    }

    public void eliminarEstudiante(View v) {
        MainActivity.myDBAdapter.eliminarEstudiante(Integer.parseInt(this.id.getText().toString()));
    }
}
