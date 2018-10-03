package com.orvea.asus.orvea;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.orvea.asus.orvea.DAO.DataItem;
import com.orvea.asus.orvea.DAO.ListesMembreAdapter;

import java.util.ArrayList;


public class ListeMembresActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mToggle;
    Toolbar mToolbar;
    ListView listView;
    ArrayList<DataItem> listM=new ArrayList<DataItem>();;
    ListesMembreAdapter myAdapter;
    DataItem dataItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_membres);

        drawerLayout = findViewById(R.id.drawerLayout);
        listView=findViewById(R.id.list);
        mToolbar = findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.chlose, R.string.open);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_act);
        navigationView.setNavigationItemSelectedListener(this);

        for(int i=0;i<10;i++){

            dataItem=new DataItem( R.drawable.ic_user,"Nom Membre","Etat membre");
            listM.add(dataItem);
        }
        myAdapter=new ListesMembreAdapter(this,listM);
        listView.setAdapter(myAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                startActivity(new Intent(this,Profile.class));
                return true;
            case R.id.item2:
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item6:
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }

    }

    public void InviteMembre(View view) {
        startActivity(new Intent(this,ListContact.class));
    }
}
