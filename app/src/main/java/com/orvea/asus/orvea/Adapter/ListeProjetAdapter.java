package com.orvea.asus.orvea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.orvea.asus.orvea.R;

import java.util.ArrayList;

public class ListeProjetAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list;

    public ListeProjetAdapter(Context context, ArrayList<String> list) {
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
        View row = inflater.inflate(R.layout.row_projet, null);

        TextView titre = (TextView) row.findViewById(R.id.titre);

        titre.setText(list.get(i));


        return row;
    }
}
