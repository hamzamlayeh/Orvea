package com.orvea.asus.orvea.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orvea.asus.orvea.Model.ItemDosserRapport;
import com.orvea.asus.orvea.R;

import java.util.ArrayList;

public class ListeDossierRapportAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemDosserRapport> list;

    public ListeDossierRapportAdapter(Context context, ArrayList<ItemDosserRapport> list) {
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
        @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.row_dossier_projet, null);

        TextView titre = (TextView) row.findViewById(R.id.NomProjet);
        ImageView image = (ImageView) row.findViewById(R.id.image);

        titre.setText(list.get(i).getNomProjet());
//        image.setImageURI(Uri.parse(list.get(i).getImage()));


        return row;
    }
}
