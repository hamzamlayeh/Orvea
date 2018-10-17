package com.orvea.asus.orvea;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EnvoyerRapport extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ToggleButton m1,m2,m3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoyer_rapport);
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

         m1 =  findViewById(R.id.model1);
         m2 = (ToggleButton) findViewById(R.id.model2);
         m3 = (ToggleButton) findViewById(R.id.model3);

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
            case R.id.nav_listM:
                startActivity(new Intent(this, ListesMembresActivity.class));
                break;
            case R.id.nav_addm:
                startActivity(new Intent(this, ListContact.class));
                break;
            case R.id.nav_listR:
                startActivity(new Intent(this, AjoutRapportActivity.class));
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

    public void m1(View view) {
        m1.setBackgroundResource(R.drawable.modele_ma);
        m2.setBackgroundResource(R.drawable.modele_c);
        m3.setBackgroundResource(R.drawable.modele_b);
    }

    public void m2(View view) {
        m1.setBackgroundResource(R.drawable.modele_a);
        m2.setBackgroundResource(R.drawable.modele_mc);
        m3.setBackgroundResource(R.drawable.modele_b);
    }

    public void m3(View view) {
        m1.setBackgroundResource(R.drawable.modele_a);
        m2.setBackgroundResource(R.drawable.modele_c);
        m3.setBackgroundResource(R.drawable.modele_mb);
    }
}
