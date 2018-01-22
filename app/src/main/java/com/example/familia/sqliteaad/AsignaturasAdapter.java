package com.example.familia.sqliteaad;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.familia.sqliteaad.Modelo.Asignatura;
import com.example.familia.sqliteaad.Modelo.Estudiante;

import java.util.ArrayList;

/**
 * Created by yo on 22/01/2018.
 */

public class AsignaturasAdapter extends BaseAdapter {
    Context context;
    ArrayList<Asignatura> asignaturas;
    public AsignaturasAdapter(Context context, ArrayList<Asignatura> asignaturas) {
        this.context=context;
        this.asignaturas=asignaturas;
    }

    @Override
    public int getCount() {
        return asignaturas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Asignatura getItem(int position) {
        return asignaturas.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.item_estudiante, null);


        Asignatura asignatura = getItem(position);
        Log.e("debug", "flipaspas "+asignatura.getNombre());
        ((TextView) view.findViewById(R.id.nombre)).setText(asignatura.getNombre());
        ((TextView) view.findViewById(R.id.curso)).setText("");
        ((TextView) view.findViewById(R.id.ciclo)).setText("Horas: "+asignatura.getHoras());

        return view;
    }
}
