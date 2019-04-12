package com.amalgamsoft.repasoii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.amalgamsoft.repasoii.adapter.GradoAdapter;
import com.amalgamsoft.repasoii.adapter.NivelAdapter;
import com.amalgamsoft.repasoii.data.Grado;
import com.amalgamsoft.repasoii.data.Nivel;
import com.amalgamsoft.repasoii.utility.DBUtility;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DBUtility conn;
    private List<Nivel> listaNivel;
    private List<Grado> listaGrado;
    private Spinner spnNivel, spnGrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnNivel = findViewById(R.id.spnNivel);
        spnGrado = findViewById(R.id.spnGrado);
        conn = new DBUtility(this);
        listaNivel = conn.getNiveles();
        int a = 1;
        spnNivel.setAdapter(new NivelAdapter(this,listaNivel));
        listaGrado = conn.getGrados(((Nivel)spnNivel.getSelectedItem()).getId());
        spnGrado.setAdapter(new GradoAdapter(this, listaGrado));
        spnNivel.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Nivel temp = ((Nivel) spnNivel.getSelectedItem());
        listaGrado = conn.getGrados(temp.getId());
        spnGrado.setAdapter(new GradoAdapter(this, listaGrado));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
