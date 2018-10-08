package com.orvea.asus.orvea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orvea.asus.orvea.Item.DataItem;
import com.orvea.asus.orvea.R;

import java.util.ArrayList;

public class ListesMembreAdapter extends BaseAdapter {

    Context context;
    ArrayList<DataItem> list;

    public ListesMembreAdapter(Context context, ArrayList<DataItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row_membre, null);

        TextView nom = (TextView) row.findViewById(R.id.name);
        TextView etat = (TextView) row.findViewById(R.id.etat);
        ImageView img = (ImageView) row.findViewById(R.id.img_membre);

        nom.setText(list.get(i).getNom_membre());
        etat.setText(list.get(i).getEtat_membre());
        img.setImageResource(list.get(i).getImg_membre());

        return row;
    }
}
