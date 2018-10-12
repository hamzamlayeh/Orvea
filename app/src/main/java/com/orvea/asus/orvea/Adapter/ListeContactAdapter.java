package com.orvea.asus.orvea.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.orvea.asus.orvea.Item.ListItem;
import com.orvea.asus.orvea.R;
import java.util.ArrayList;
import java.util.List;



public class ListeContactAdapter extends RecyclerView.Adapter<ListeContactAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom, num;
       ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            nom = itemView.findViewById(R.id.C_nom);
            num = itemView.findViewById(R.id.C_num);



        }
    }

    private Context context;
    private List<ListItem> list;

    public ListeContactAdapter(Context context, ArrayList<ListItem> list) {

        this.context = context;
        this.list = list;

    }

    @Override
    public ListeContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ListeContactAdapter.ViewHolder holder, int position) {


        holder.nom.setText(list.get(position).getName());
        holder.num.setText(list.get(position).getDesc());



//        Toast.makeText(context, ""+holder.id.getText(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


