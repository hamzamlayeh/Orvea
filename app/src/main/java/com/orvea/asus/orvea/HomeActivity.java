package com.orvea.asus.orvea;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.orvea.asus.orvea.ListContact.MY_PERMISSIONS_REQUEST;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkFineLocationPermission();
        }
    }

    public void connexion(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void inscrire(View view) {
        startActivity(new Intent(this, InscriptionActivity.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS,
                            Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST);
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkFineLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS,
                    Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST);

        }
    }
}
