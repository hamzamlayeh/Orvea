package com.orvea.asus.orvea;

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ListContact extends AppCompatActivity {
    final static int MY_PERMISSIONS_REQUEST = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if( getApplicationContext().checkSelfPermission( Manifest.permission.READ_CONTACTS ) != PackageManager.PERMISSION_GRANTED )
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
//
//        }

        recupContact();
    }
    public void recupContact(){
        ContentResolver contentProvider =this.getContentResolver();
        Cursor cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                ContactsContract.CommonDataKinds.Phone.NUMBER},null,null,null);
        if (cursor==null){
            Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                String num=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.i("nom",name);
                Log.i("num",num);
            }
        }
    }




}
