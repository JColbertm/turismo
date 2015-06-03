package com.turismo.software.turismo;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Clases on 20/05/2015.
 */
public class Registro extends ActionBarActivity implements OnClickListener {
    private EditText user, pass,nom;
    private Button  mRegister, mSubmit;

    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //si lo trabajan de manera local en xxx.xxx.x.x va su ip local
    // private static final String REGISTER_URL = "http://xxx.xxx.x.x:1234/cas/register.php";

    //testing on Emulator:
    private static final String REGISTER_URL = "http://turismolapaz.16mb.com/turilogin/register.php";

    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    protected TextView luga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        luga = (TextView)findViewById(R.id.formulario);
        Typeface font = Typeface.createFromAsset(getAssets(),"UbuntuTitling-Bold.ttf");
        luga.setTypeface(font);

        nom = (EditText)findViewById(R.id.nombre);
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pas);

        mRegister = (Button)findViewById(R.id.registrar);
        mRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.registrar:
                new CreateUser().execute();
                break;
            default:
                break;
        }

    }

    class CreateUser extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Registro.this);
            pDialog.setMessage("Creating User...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success;
            String nombre = nom.getText().toString();
            String username = user.getText().toString();
            String password = pass.getText().toString();
            try {
                // Building Parameters
                List params = new ArrayList();
                params.add(new BasicNameValuePair("nombre", nombre));
                params.add(new BasicNameValuePair("usuario", username));
                params.add(new BasicNameValuePair("password", password));

                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                        REGISTER_URL, "POST", params);

                // full json response
                Log.d("Registering attempt", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("User Created!", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Registering Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                pDialog.setMessage("No hay conexion");
                e.printStackTrace();
            }

            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(Registro.this, file_url, Toast.LENGTH_LONG).show();
            }
        }
    }
}

