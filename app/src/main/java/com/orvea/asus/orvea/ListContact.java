package com.orvea.asus.orvea;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.orvea.asus.orvea.Adapter.ListeContactAdapter;
import com.orvea.asus.orvea.Helper.RecyclerViewClickListener;
import com.orvea.asus.orvea.Helper.RecyclerViewTouchListener;
import com.orvea.asus.orvea.Model.ListItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListContact extends AppCompatActivity {
    final static int MY_PERMISSIONS_REQUEST = 2;
    ArrayList<ListItem> Items = new ArrayList<ListItem>();
    RecyclerView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSMSPermission();
        }
        recupContact();
        ls = findViewById(R.id.RecyclerView);
        ls.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        ListeContactAdapter myadpter = new ListeContactAdapter( this,Items);
        ls.setAdapter(myadpter);

        ls.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), ls, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                String nom =Items.get(position).getName();
                String num =Items.get(position).getDesc();
                String msg = "Lien de l aplication";
             try {
                   SmsManager sms = SmsManager.getDefault();
//                    sms.sendTextMessage(num, null, msg, null, null);
                }catch (Exception e){
                    Toast.makeText(ListContact.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(ListContact.this, "Invitation  envoiye par SMS a :"+nom+" \nNuméro :"+ num, Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    public void recupContact() {
        ContentResolver contentProvider = this.getContentResolver();

                Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                                ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
                if (cursor == null) {
                    Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_SHORT).show();
                } else {
                    while (cursor.moveToNext()) {

                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                        String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        Items.add(new ListItem(name, num));
                        Collections.sort(Items, new Comparator<ListItem>() {
                            @Override
                            public int compare(ListItem o1, ListItem o2) {
                                return o1.getName().compareTo(o2.getName());
                            }
                        });
                    }
                    cursor.close();
                }
        }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS,
                            Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST);
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkSMSPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.SEND_SMS,
                    Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST);

        }
    }

}
