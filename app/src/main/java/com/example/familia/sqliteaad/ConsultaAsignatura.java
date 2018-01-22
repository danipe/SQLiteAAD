package com.example.familia.sqliteaad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.familia.sqliteaad.Modelo.Asignatura;
import com.example.familia.sqliteaad.Modelo.Estudiante;

import java.util.ArrayList;

public class ConsultaAsignatura extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_asignatura);
        listView = findViewById(R.id.listView);
        ArrayList<Asignatura> asignaturasAMostrar = MainActivity.myDBAdapter.consultarAsginaturas("SELECT * from asignaturas");
        AsignaturasAdapter asignaturasAdapter = new AsignaturasAdapter(getApplicationContext(), asignaturasAMostrar);
        listView.setAdapter(asignaturasAdapter);
    }
}
