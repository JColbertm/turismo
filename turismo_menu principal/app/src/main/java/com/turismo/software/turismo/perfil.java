package com.turismo.software.turismo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Clases on 20/05/2015.
 */
public class perfil extends ActionBarActivity {
    protected TextView tit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tit = (TextView)findViewById(R.id.pe);
        Typeface font = Typeface.createFromAsset(getAssets(),"UbuntuTitling-Bold.ttf");
        tit.setTypeface(font);


    }

}
