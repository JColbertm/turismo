package com.turismo.software.turismo;

        import java.util.HashMap;
        import java.util.List;

        import android.app.FragmentTransaction;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Toast;

public class main_mapa extends ActionBarActivity implements OnTaskCompleted{
    //private static String APP_TAG = "APIRutasGoogle";
    MyMapFragment myMapFrag;
    MainFragment myMainFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_principal_fragment);
        if (savedInstanceState == null) {
            myMainFrag = new MainFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.container, myMainFrag);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } //else if (id == R.id.action_back) {

       // }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTaskCompleted(List<List<HashMap<String, String>>> listLatLong) {
        if (listLatLong != null && listLatLong.size() > 0) {
            //Instanciamos MyMapFragment y le pasamos el listado de Latitudes y Longitudes
            //necesarios para trazar la ruta entre el punto A y el B
            myMapFrag= new MyMapFragment();
            myMapFrag.setRoutes(listLatLong);

            //Se hace el cambio de Fragment entre el Main y el Map empleando FragmentTransaction
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, myMapFrag);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            Toast.makeText(this, "Oops!, No se logro determinar ruta ;(", Toast.LENGTH_LONG).show();
        }

    }
}
