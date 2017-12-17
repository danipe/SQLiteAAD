package com.example.familia.sqliteaad;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.familia.sqliteaad.Modelo.Estudiante;

import java.util.ArrayList;

/**
 * Created by yo on 17/12/2017.
 */

public class EstudiantesAdapter extends BaseAdapter {
    Context context;
    ArrayList<Estudiante> estudiantes;
    public EstudiantesAdapter(Context context, ArrayList<Estudiante> estudiantes) {
        this.context=context;
        this.estudiantes=estudiantes;
    }

    @Override
    public int getCount() {
        return estudiantes.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Estudiante getItem(int position) {
        return estudiantes.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_estudiante, null);


        Estudiante estudiante = getItem(position);
        Log.e("debug", "flipaspas "+estudiante.getNombre());
        ((TextView) view.findViewById(R.id.nombre)).setText(estudiante.getNombre());
        ((TextView) view.findViewById(R.id.curso)).setText("Curso: "+estudiante.getCurso());
        ((TextView) view.findViewById(R.id.ciclo)).setText("Ciclo: "+estudiante.getCiclo());

        return view;
    }
}
