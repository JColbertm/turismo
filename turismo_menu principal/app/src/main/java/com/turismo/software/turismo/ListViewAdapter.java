package com.turismo.software.turismo;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Clases on 25/05/2015.
 */
public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] titulos;
    int[] imagenes;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] titulos, int[] imagenes) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    public int getCount() {
        return titulos.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.list_row_title);
        imgImg = (ImageView) itemView.findViewById(R.id.list_row_image);

        // Capture position and set to the TextViews
        txtTitle.setText(titulos[position]);
        imgImg.setImageResource(imagenes[position]);

        return itemView;
    }


}
