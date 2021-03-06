package com.amalgamsoft.repasoii.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amalgamsoft.repasoii.R;
import com.amalgamsoft.repasoii.data.Grado;
import com.amalgamsoft.repasoii.data.Nivel;

import java.util.List;

public class GradoAdapter extends ArrayAdapter<Grado> {
    private Context context;
    private List<Grado> objetos;
    private int layout;
    public GradoAdapter( @NonNull Context context,   @NonNull List<Grado> objects) {
        super(context, R.layout.item_layout, objects);
        this.context = context;
        this.objetos = objects;
        layout = R.layout.item_layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(layout, null);
        }

        if (objetos.get(position) != null) {
            TextView nombre = v.findViewById(R.id.txtItem);
            nombre.setText(objetos.get(position).getNombre());
        }
        return  v;
    }

    @Override
    public View getDropDownView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(layout, null);
        }

        if (objetos.get(position) != null) {
            TextView nombre = v.findViewById(R.id.txtItem);
            nombre.setText(objetos.get(position).getNombre());
        }
        return  v;
    }
}
