package com.turismo.software.turismo;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;


/**
 * Created by Clases on 29/05/2015.
 */
public class locacion implements LocationListener {
    public mapa getMapa() {
        return Mapa;
    }

    public void setMapa(mapa mapa) {
        Mapa = mapa;
    }

    mapa Mapa;


    @Override
    public void onLocationChanged(Location loc) {
        Log.d("latitud","MAPA FEO" );
        loc.getLatitude();
        loc.getLongitude();
        String lat = String.valueOf(loc.getLatitude());
        Log.d("latitud",lat );

        String lon = String.valueOf(loc.getLongitude());
        Log.d("longitud",lon );

   //     this.Mapa.setLocation(loc);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
     }


    @Override
    public void onProviderEnabled(String provider) {
        Log.d("System.out","GPS activado");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("System.out","GPS desactivado");
    }
}
