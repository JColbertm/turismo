package com.turismo.software.turismo;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Clases on 26/05/2015.
 */
public class listar_lugares extends ActionBarActivity {
    int[] imagenComidas = {
            R.drawable.copacabana1,
            R.drawable.dumbo1,
            R.drawable.elis1,
            R.drawable.brosso1,
            R.drawable.chope1,
            R.drawable.mburger1,
            R.drawable.alex1
    };

    int[] imagenHospitales = {
            R.drawable.mm1,
            R.drawable.clini1,
            R.drawable.materno1,
            R.drawable.ninio1,
            R.drawable.ob1,
            R.drawable.tor1,
            R.drawable.uria1
    };
    int[] imagenMuseos= {
            R.drawable.natural1,
            R.drawable.textiles1,
            R.drawable.contemporaneo1,
            R.drawable.sanfra1,
            R.drawable.arte1,
            R.drawable.quirquincho1,
            R.drawable.pedro1,
            R.drawable.litoral1,
            R.drawable.metal1,
            R.drawable.costumbrista1
    };
    int[] imagenPuma = {
            R.drawable.salome1,
            R.drawable.inca1,
            R.drawable.chasqui1
     };
    int[] imagenTeleferico = {
            R.drawable.verde1,
            R.drawable.amarilla1,
            R.drawable.roja1
    };

    int[] imagenPlaza = {
            R.drawable.psanpedro1,
            R.drawable.pabaroa1,
            R.drawable.pmurillo1,
            R.drawable.phumbolt1,
            R.drawable.pestudiante1
    };

    String[] titulo;
    String[] contenido;

    private ListView lista;
    ListViewAdapter adapter;

    int currentViewPager;
    int nombreCircuito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_lugar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);  //ir atras


        actionBar.setTitle("Lugares encontrados");
        actionBar.setSubtitle("Seleccione un lugar");


        Bundle extras = getIntent().getExtras();
        nombreCircuito = extras.getInt("nombreCircuito");
       // Log.i("ramiro", "currentViewPager: " + currentViewPager);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

         lista = (ListView) findViewById(R.id.listView_listarCircuito);
        switch ( bundle.getInt("Numero")){
            case 0: //lista de restaurantes
                titulo = getResources().getStringArray(R.array.comidas_titulo);
                contenido = getResources().getStringArray(R.array.comidas_contenido);
                adapter = new ListViewAdapter(this, imagenComidas, titulo, contenido);
                break;
            case 1: //Lista de hospitales
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido);
                adapter = new ListViewAdapter(this, imagenHospitales, titulo, contenido);
                break;
            case 2: //Lista de hoteles
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido);
                adapter = new ListViewAdapter(this, imagenHospitales, titulo, contenido);
                break;
            case 3: //Lista de museos
                titulo = getResources().getStringArray(R.array.museos_titulo);
                contenido = getResources().getStringArray(R.array.museos_contenido);
                adapter = new ListViewAdapter(this, imagenMuseos, titulo, contenido);
                break;
            case 4: //Lista de parques
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido);
                adapter = new ListViewAdapter(this, imagenHospitales, titulo, contenido);
                break;
            case 5: //Lista de plazas
                titulo = getResources().getStringArray(R.array.plaza_titulo);
                contenido = getResources().getStringArray(R.array.plaza_contenido);
                adapter = new ListViewAdapter(this, imagenPlaza, titulo, contenido);
                break;
            case 6: //Lista pumakatari
                titulo = getResources().getStringArray(R.array.puma_titulo);
                contenido = getResources().getStringArray(R.array.puma_contenido);
                adapter = new ListViewAdapter(this, imagenPuma, titulo, contenido);
                break;
            case 7: //Lista teleferico
                titulo = getResources().getStringArray(R.array.teleferico_titulo);
                contenido = getResources().getStringArray(R.array.teleferico_contenido);
                adapter = new ListViewAdapter(this, imagenTeleferico, titulo, contenido);
                break;
            case 8: //Lista zoologico
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido);
                adapter = new ListViewAdapter(this, imagenHospitales, titulo, contenido);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();

                Intent i = new Intent(getApplicationContext(), lugar.class);
                i.putExtra("idcircuito",bundle.getInt("Numero"));
                i.putExtra("position", position);
                i.putExtra("nombreCircuito", nombreCircuito);
                i.putExtra("nombreSubCircuito", titulo[position]);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


            }
        });
    }


    /******************* LISTVIEW ADAPTER **************************/

    public class ListViewAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
            this.context = context;
            this.imagenes = imagenes;
            this.titulos = titulos;
            this.contenido = contenido;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            ImageView imgImg;
            TextView txtTitle;
            TextView txtContenido;

            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.simple_post, parent, false);
            // Locate the TextViews in listview_item.xml
            imgImg = (ImageView) itemView.findViewById(R.id.imagen_single_post_circuito);
            txtTitle = (TextView) itemView.findViewById(R.id.tv_titulo_single_post_circuito);
            txtContenido = (TextView) itemView.findViewById(R.id.tv_contenido_single_post_circuito);

            // Capture position and set to the TextViews
            imgImg.setImageResource(imagenes[position]);
            txtTitle.setText(titulos[position]);
            txtContenido.setText(contenido[position]);

            return itemView;
        }
    }
}
