package com.turismo.software.turismo;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
*/
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements OnClickListener {
    private EditText user, pass;
    private Button mSubmit, mRegister,mMapa;
    protected TextView bi;
    private ProgressDialog pDialog;


   /* private LoginButton loginButton;
    private CallbackManager callbackManager;*/

    JSONParser jsonParser = new JSONParser();

    private static final String LOGIN_URL = "http://turismolapaz.16mb.com/turilogin/login.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       /* FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();*/

         // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bi = (TextView)findViewById(R.id.fuente);
        Typeface font = Typeface.createFromAsset(getAssets(),"planetbe.ttf");
        bi.setTypeface(font);

        // setup input fields
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pas);

        // setup buttons
        mSubmit = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.registrar);


        // register listeners
        mSubmit.setOnClickListener(this);
        mRegister.setOnClickListener(this);


     /*   loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent i = new Intent(MainActivity.this, menuPrincipal.class);
            }

            @Override
            public void onCancel() {
               // info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
              //  info.setText("Login attempt failed.");
            }
        });*/


    }
/////////////



    /////////////////
    main_mapa mainAct;
    @Override
    public void onClick(View v) {

        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.login:
                new AttemptLogin().execute();
                break;
            case R.id.registrar:
                Intent i = new Intent(this, Registro.class);
                startActivity(i);
                break;

               // } else {
              //      Toast.makeText(MainActivity.this.mainAct, "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
               // }

                //   startActivity(new Intent(MainActivity.this, main_mapa.class));


            default:
                break;
        }
    }
    int c=1;
    class AttemptLogin extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Attempting login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            int success;
            String username = user.getText().toString();
            String password = pass.getText().toString();
            try {
                // Building Parameters
                List params = new ArrayList();
                params.add(new BasicNameValuePair("usuario", username));
                params.add(new BasicNameValuePair("pass", password));

                Log.d("request!", "starting");
                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST",
                        params);

                // check your log for json response
                Log.d("Login attempt", json.toString());

                // json success tag
                success = json.getInt(TAG_SUCCESS);

                if(c<=3){
                if (success == 1) {
                    Log.d("Login Successful!", json.toString());
                    // save user data
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("usuario", username);
                    edit.commit();

                    Intent i = new Intent(MainActivity.this, menuPrincipal.class);
                    finish();
                    startActivity(i);
                    return json.getString(TAG_MESSAGE);
                } else {
                    Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                    c++;
                    return json.getString(TAG_MESSAGE);
                }
                }
                else {
                    Toast.makeText(MainActivity.this, "Numero de intentos exedidos",Toast.LENGTH_LONG).show();

                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(MainActivity.this, file_url, Toast.LENGTH_LONG).show();
            }
        }
    }



}
