package com.turismo.software.turismo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainFragment extends Fragment {
    private static String APP_TAG = "APIRutasGoogle";
    private TextView _txtPointA;
    private TextView _txtPointB;
    private Button _btnCalcRoute;
    private main_mapa mainAct;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);


        setupUI(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Obtenemos la referencia a la Actividad principal
        this.mainAct = (main_mapa) activity;
    }
    private EditText rutaA,rutaB;
    public void setupUI(View rootView) {
        //Se mapea los componentes UI en el fragment_main.xml con variables para su manipulación.
        //rutaA = (EditText) rootView.findViewById(R.id.textPointA);
       // rutaA.setText(lugar.Global.lonlat);

       // rutaB = (EditText) rootView.findViewById(R.id.textPointB);
       // rutaB.setText(lugar.Global.lonlat2);

        _btnCalcRoute = (Button) rootView.findViewById(R.id.btnCalcRoute);

        //Se define un OnClickListener al botón de Calcular Ruta:
        _btnCalcRoute.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(APP_TAG, "_btnCalcRoute fue pulsado");
                //Obtenemos la dirección A y B obtenida por el usuario.
                Log.d("longlat",lugar.Global.lonlat);
                Log.d("longlat2",lugar.Global.lonlat2);
                String pointA = lugar.Global.lonlat;
                String pointB = lugar.Global.lonlat2;//"-16.511497, -68.122017"; //******lugar.Global.lonlat2;

                if (pointA != null && pointA != "" && pointB != null && pointB != "") {
                    //Disparamos la tarea asíncrona definida en la clase ManageGoogleRoutes
                    //pasando los puntos A y B para el calculo de la ruta y la obtención de
                    //las coordenadas que nos permitirán dibujar la ruta a seguir.
                    new ManageGoogleRoutes(MainFragment.this.mainAct).execute(pointA, pointB);
                } else {
                    Toast.makeText(MainFragment.this.mainAct, "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}