package com.example.familia.sqliteaad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Asignaturas extends AppCompatActivity {
    EditText nombre, horas, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        nombre = findViewById(R.id.nombre);
        horas = findViewById(R.id.horas);
        id = findViewById(R.id.id);
    }

    public void reestablecerAsignatura(View v) {
        nombre.setText("");
        horas.setText("");
    }

    public void insertarAsignatura(View v) {
        MainActivity.myDBAdapter.insertarAsignatura(
                nombre.getText().toString(),
                Integer.parseInt(horas.getText().toString()));
    }

    public void eliminarAsignatura(View v) {
        MainActivity.myDBAdapter.eliminarAsignatura(Integer.parseInt(id.getText().toString()));
    }

}
