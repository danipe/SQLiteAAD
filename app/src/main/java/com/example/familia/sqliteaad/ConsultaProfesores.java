package com.example.familia.sqliteaad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.familia.sqliteaad.Modelo.Estudiante;
import com.example.familia.sqliteaad.Modelo.Profesor;

import java.util.ArrayList;

public class ConsultaProfesores extends AppCompatActivity {
    EditText curso, ciclo;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_profesores);
        this.curso = findViewById(R.id.curso);
        this.ciclo = findViewById(R.id.ciclo);
        this.listView = findViewById(R.id.listView);
    }

    public void consultarProfesores(View v) {
        //"CREATE TABLE estudiantes (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, nota integer);"
        String sql = "";

        switch (this.checkET()) {
            case 0:
                sql = "SELECT * FROM profesores;";
                break;
            case 1:
                sql = "SELECT * FROM profesores WHERE ciclo = \""+this.ciclo.getText().toString()+"\" ;";
                break;
            case 2:
                sql = "SELECT * FROM profesores WHERE curso = \""+this.curso.getText().toString()+"\" ;";
                break;
            case 3:
                sql = "SELECT * FROM profesores WHERE ciclo = \""+this.ciclo.getText().toString()+"\" AND curso = \"" + this.curso.getText().toString() + "\" ;";
                break;
        }
        Log.e("debug", sql);
        ArrayList<Profesor> profesoresAMostrar = MainActivity.myDBAdapter.consultarProfesores(sql);
        ProfesoresAdapter profesoresAdapter = new ProfesoresAdapter(getApplicationContext(), profesoresAMostrar);
        listView.setAdapter(profesoresAdapter);
    }

    public int checkET() {
        //0: todos,1: ciclo, 2: curso, 3: ciclo y curso
        if(this.ciclo.getText().toString().length()>0) {
            if(this.curso.getText().toString().length()>0) {
                return 3;
            } else {
                return 1;
            }
        }else if(this.curso.getText().toString().length()>0) {
            return 2;
        } else {
            return 0;
        }
    }
}
