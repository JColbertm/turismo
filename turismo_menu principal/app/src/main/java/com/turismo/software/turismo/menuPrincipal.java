package com.turismo.software.turismo;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Clases on 20/05/2015.
 */
public class menuPrincipal extends ActionBarActivity implements OnClickListener, AdapterView.OnItemClickListener {
    private ImageButton comida, hospital, hotel, iglesia, parque, plaza, puma, teleferico, zoo;
    private DrawerLayout mDrawer;
    private ListView mDrawerOptions;
    protected TextView menuFont;
    private static final String[] values = {"Perfil", "Lugares", "Itinerario"};
    public String nombreCircuito;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();



        actionBar.setTitle("Menu principal");
        //actionBar.setSubtitle("Menu principal");

        menuFont = (TextView)findViewById(R.id.menunom);
        Typeface font = Typeface.createFromAsset(getAssets(),"RemachineScript_Personal_Use.ttf");
        menuFont.setTypeface(font);

        mDrawerOptions = (ListView) findViewById(R.id.left_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerOptions.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values));
        mDrawerOptions.setOnItemClickListener(this);

        comida = (ImageButton) findViewById(R.id.im1);
        hospital = (ImageButton) findViewById(R.id.im2);
        hotel = (ImageButton) findViewById(R.id.im3);
        iglesia = (ImageButton) findViewById(R.id.im4);
        parque = (ImageButton) findViewById(R.id.im5);
        plaza = (ImageButton) findViewById(R.id.im6);
        puma = (ImageButton) findViewById(R.id.im7);
        teleferico = (ImageButton) findViewById(R.id.im8);
        zoo = (ImageButton) findViewById(R.id.im9);

        // register listeners
        comida.setOnClickListener(this);
        hospital.setOnClickListener(this);
        hotel.setOnClickListener(this);
        iglesia.setOnClickListener(this);
        parque.setOnClickListener(this);
        plaza.setOnClickListener(this);
        puma.setOnClickListener(this);
        teleferico.setOnClickListener(this);
        zoo.setOnClickListener(this);

    }



      public void onClick(View v) {
          // TODO Auto-generated method stub
          Bundle bund = new Bundle();
          Intent s = new Intent(menuPrincipal.this, listar_lugares.class);
          switch (v.getId()) {
              case R.id.im1:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 0 );
                  s.putExtras(bund);
                   startActivity(s);
                  break;
              case R.id.im2:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 1 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;
              case R.id.im3:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 2 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;

              case R.id.im4:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 3 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;

              case R.id.im5:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 4 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;

              case R.id.im6:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 5 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;

              case R.id.im7:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 6 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;

              case R.id.im8:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 7 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;

              case R.id.im9:
                  System.out.print("hola");
                  bund.putInt( "Numero" , 8 );
                  s.putExtras(bund);
                  startActivity(s);
                  break;
              default:
                  break;
          }
      }
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        if(values[i].compareTo("perfil")!=0)
        {
            Intent r = new Intent(menuPrincipal.this, perfil.class);
            finish();
            startActivity(r);
        }
        Toast.makeText(this, "Pulsado " + values[i], Toast.LENGTH_SHORT).show();

        mDrawer.closeDrawers();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        	    switch (item.getItemId()){
            	        case android.R.id.home:
                	            if (mDrawer.isDrawerOpen(mDrawerOptions)){
                    	                mDrawer.closeDrawers();
                    	            }else{
                    	                mDrawer.openDrawer(mDrawerOptions);
                    	            }
                	            return true;
                }

        	    return super.onOptionsItemSelected(item);
        	}



  }





