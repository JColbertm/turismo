package com.turismo.software.turismo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View;



import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Clases on 26/05/2015.
 */
public class lugar extends ActionBarActivity implements OnClickListener {
    private ImageView imgImagen;
    private TextView txtTitulo, txtContenido;
    String[] titulo;
    String[] contenido;
    String[] coor;
    String lat;


    private int[] imagenComidas = {
            R.drawable.copacabana1,
            R.drawable.dumbo1,
            R.drawable.elis1,
            R.drawable.brosso1,
            R.drawable.chope1,
            R.drawable.mburger1,
            R.drawable.alex1};

    private int[] imagenHopspitales = {
            R.drawable.mm1,
            R.drawable.clini1,
            R.drawable.materno1,
            R.drawable.ninio1,
            R.drawable.ob1,
            R.drawable.tor1,
            R.drawable.uria1
    };
    int[] imagenMuseos = {
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


    protected TextView lugarFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lugar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);  //ir atras

       LocationManager milocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener milocListener = new MiLocationListener();
        milocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, milocListener);




        lugarFont = (TextView) findViewById(R.id.tv_titulo_listaruncircuito);
        Typeface font = Typeface.createFromAsset(getAssets(), "UbuntuTitling-Bold.ttf");
        lugarFont.setTypeface(font);


        Bundle extras = getIntent().getExtras();
        int idcircuito = extras.getInt("idcircuito");
        final int position = extras.getInt("position");


        String nombreCircuito = extras.getString("nombreCircuito");
        String nombreSubCircuito = extras.getString("nombreSubCircuito");

         /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle(nombreCircuito);
        actionBar.setSubtitle(nombreSubCircuito);

        txtTitulo = (TextView) findViewById(R.id.tv_titulo_listaruncircuito);
        txtContenido = (TextView) findViewById(R.id.tv_contenido_listaruncircuito);
        imgImagen = (ImageView) findViewById(R.id.iv_imagen_listaruncircuito);


        Bundle bund = new Bundle();
        // Intent g = new Intent(lugar.this, ACA VA EL MAPA.class);
        switch (idcircuito) {
            case 0: //restaurantes
                titulo = getResources().getStringArray(R.array.comidas_titulo);
                contenido = getResources().getStringArray(R.array.comidas_contenido_completo);
                imgImagen.setImageResource(imagenComidas[position]);
                coor = getResources().getStringArray(R.array.comidas_lonlat);

                //startActivity(g);

                break;
            case 1: //hospitales
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido_completo);
                imgImagen.setImageResource(imagenHopspitales[position]);
                break;
            case 2: //hoteles
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido_completo);
                imgImagen.setImageResource(imagenHopspitales[position]);
                break;
            case 3: //museos
                titulo = getResources().getStringArray(R.array.museos_titulo);
                contenido = getResources().getStringArray(R.array.museos_contenido_completo);
                imgImagen.setImageResource(imagenMuseos[position]);
                coor = getResources().getStringArray(R.array.museos_lonlat);
                break;
            case 4: //parques
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido_completo);
                imgImagen.setImageResource(imagenHopspitales[position]);
                break;
            case 5: //plazas
                titulo = getResources().getStringArray(R.array.plaza_titulo);
                contenido = getResources().getStringArray(R.array.plaza_contenido_completo);
                imgImagen.setImageResource(imagenPlaza[position]);
                coor = getResources().getStringArray(R.array.plaza_lonlat);
                break;
            case 6: //puma
                titulo = getResources().getStringArray(R.array.puma_titulo);
                contenido = getResources().getStringArray(R.array.puma_contenido_completo);
                imgImagen.setImageResource(imagenPuma[position]);
                coor = getResources().getStringArray(R.array.puma_lonlat);
                break;
            case 7: //teleferico
                titulo = getResources().getStringArray(R.array.teleferico_titulo);
                contenido = getResources().getStringArray(R.array.teleferico_contenido_completo);
                imgImagen.setImageResource(imagenTeleferico[position]);
                coor = getResources().getStringArray(R.array.teleferico_lonlat);
                break;
            case 8: //zoo
                titulo = getResources().getStringArray(R.array.hospitales_titulo);
                contenido = getResources().getStringArray(R.array.hospitales_contenido_completo);
                imgImagen.setImageResource(imagenHopspitales[position]);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        txtTitulo.setText(titulo[position]);
        txtContenido.setText(contenido[position]);
        lat = coor[position];
        Global.lonlat = lat;



        Button ubicar = (Button) findViewById(R.id.ir); //Definimos el boton
        ubicar.setOnClickListener(this);


        Log.d("coordenada", Global.lonlat);


    }

    public class MiLocationListener implements LocationListener
    {
        public void onLocationChanged(Location loc)
        {
            loc.getLatitude();
            loc.getLongitude();
            String coordenadas = "Mis coordenadas son: " + "Latitud = " + loc.getLatitude() + "Longitud = " + loc.getLongitude();
            String h= ""+loc.getLatitude()+", "+loc.getLongitude();
            Global.lonlat2 = h;
            Log.d("Mi ubicacion actual concatenada: ",h);
          //  Toast.makeText( getApplicationContext(),coordenadas,Toast.LENGTH_LONG).show();
        }
        public void onProviderDisabled(String provider)
        {
            Toast.makeText( getApplicationContext(),"Gps Desactivado, Activelo para obtener la ubicacion del lugar.",Toast.LENGTH_SHORT ).show();
        }
        public void onProviderEnabled(String provider)
        {
            Toast.makeText( getApplicationContext(),"Gps Activo, espere un momento. ",Toast.LENGTH_SHORT ).show();
        }
        public void onStatusChanged(String provider, int status, Bundle extras){}
    }

    public static class Global {
        public static String lonlat;
        public static String lonlat2;
    }

    public void onClick(View control_pulsado) {
        //  Bundle bund = new Bundle();
        //  bund.putInt("Numero", 0);
        // s.putExtras(bund);

        Intent m = new Intent(this, main_mapa.class);
        startActivity(m);
        //     ManageGoogleRoutes(lugar.this.mainAct).execute(pointA, pointB);


    }


    public void setLocation(Location loc) {
        //Obtener la direcci—n de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address address = list.get(0);
                    Log.d("", "Mi direcci—n es: \n"
                            + address.getAddressLine(0));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}



