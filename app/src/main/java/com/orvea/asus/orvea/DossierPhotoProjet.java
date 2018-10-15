package com.orvea.asus.orvea;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.orvea.asus.orvea.Adapter.ListeDossierPhotoAdapter;
import com.orvea.asus.orvea.Model.ItemDosserPhoto;

import java.util.ArrayList;

public class DossierPhotoProjet extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gridView;
    ArrayList<ItemDosserPhoto> list = new ArrayList<ItemDosserPhoto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dossier_photo_projet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));
        list.add(new ItemDosserPhoto("khaled hizawi", ""));

        gridView = findViewById(R.id.grid);
        gridView.setAdapter(new ListeDossierPhotoAdapter(this, list));
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_profil:
                startActivity(new Intent(this, ProfilsActivity.class));
                break;
            case R.id.nav_list:
                startActivity(new Intent(this, ListesMembresActivity.class));
                break;
            case R.id.nav_addr:
                startActivity(new Intent(this, AjoutRapportActivity.class));
                break;
            case R.id.nav_dec:
//                startActivity(new Intent(this, AjoutRapportActivity.class));
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void CreerRapport(View view) {
        startActivity(new Intent(this, CreeRapport.class));
    }
}
