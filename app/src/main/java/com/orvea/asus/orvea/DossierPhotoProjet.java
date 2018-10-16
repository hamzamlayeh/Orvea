package com.orvea.asus.orvea;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.orvea.asus.orvea.Adapter.ListeDossierPhotoAdapter;
import com.orvea.asus.orvea.Model.ItemDosserPhoto;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.PicassoAdapter;
import com.sangcomz.fishbun.define.Define;

import java.util.ArrayList;

public class DossierPhotoProjet extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gridView;
    ArrayList<ItemDosserPhoto> list = new ArrayList<ItemDosserPhoto>();
    ArrayList<Uri> path = new ArrayList<>();

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
                startActivity(new Intent(this, AjoutRapportActivity.class));
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void CreerRapport(View view) {
        startActivity(new Intent(this, CreeRapport.class));
    }

    public void Liste_rapport(View view) {
        startActivity(new Intent(this, AjoutRapportActivity.class));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageData) {
        super.onActivityResult(requestCode, resultCode, imageData);
        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    // path = imageData.getStringArrayListExtra(Define.INTENT_PATH);
                    // you can get an image path(ArrayList<String>) on <0.6.2

                    path = imageData.getParcelableArrayListExtra(Define.INTENT_PATH);
                    // you can get an image path(ArrayList<Uri>) on 0.6.2 and later
                    break;
                }
        }
    }

    public void OpenGallery(View view) {
        FishBun.with(this)
                .setImageAdapter(new PicassoAdapter())
                .setPickerSpanCount(4)
                .setPickerCount(10000)
                .setActionBarColor(Color.parseColor("#c9c9cf"), Color.parseColor("#0c3376"), true)
                .setActionBarTitleColor(Color.parseColor("#0c3376"))
                .setSelectedImages(path)
                .setAlbumSpanCount(1, 2)
                .setButtonInAlbumActivity(true)
                .setCamera(true)
                .exceptGif(true)
                .setReachLimitAutomaticClose(false)
                .setHomeAsUpIndicatorDrawable(ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp))
                .setOkButtonDrawable(ContextCompat.getDrawable(this, R.drawable.ic_check_black_24dp))
                .setAllViewTitle("Toutes vos photos")
                .setActionBarTitle("Oreve")
                .textOnImagesSelectionLimitReached("Vous ne pouvez plus en sélectionner.")
                .textOnNothingSelected("J'ai besoin d'une photo!")
                .startAlbum();
    }


}
