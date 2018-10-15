package com.orvea.asus.orvea;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.orvea.asus.orvea.Model.ItemDosserRapport;
import com.orvea.asus.orvea.Adapter.ListeDossierRapportAdapter;

import java.util.ArrayList;

public class AjoutRapportActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gridView;
    ArrayList<ItemDosserRapport> list=new ArrayList<ItemDosserRapport>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_rapport);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));
        list.add(new ItemDosserRapport("khaled",""));

        gridView=findViewById(R.id.grid);
        gridView.setAdapter(new ListeDossierRapportAdapter(this,list));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ajout_rapport, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add) {
           startActivity(new Intent(this, CreeRapport.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_profil:
                startActivity(new Intent(this, ProfilsActivity.class));
                break;
            case R.id.nav_listM:
                startActivity(new Intent(this, ListesMembresActivity.class));
                break;
            case R.id.nav_addm:
                startActivity(new Intent(this, ListContact.class));
                break;
            case R.id.nav_listR:
//                startActivity(new Intent(this, AjoutRapportActivity.class));
                break;
            case R.id.nav_addr:
                startActivity(new Intent(this, CreeRapport.class));
                break;
            case R.id.nav_listP:
                startActivity(new Intent(this, ListeProjetActivity.class));
                break;
            case R.id.nav_addp:
                startActivity(new Intent(this, CreeProjet.class));
                break;
            case R.id.nav_dec:
//                startActivity(new Intent(this, AjoutRapportActivity.class));
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
