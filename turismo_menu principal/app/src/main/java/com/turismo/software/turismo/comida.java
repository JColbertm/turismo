package com.turismo.software.turismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Clases on 22/05/2015.
 */
public class comida extends ActionBarActivity{
    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "titulo1",
            "titulo2",
            "titulo3",
            "titulo4",
    };

    int[] imagenes = {
            R.drawable.icon01,
            R.drawable.icon01,
            R.drawable.icon01,
            R.drawable.icon01
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comida);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(this, titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        volver();
    }

    private void volver() {
        Button volver = (Button) findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(comida.this, menuPrincipal.class));
            }
        } );


    }
}
