package com.orvea.asus.orvea;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.orvea.asus.orvea.Adapter.ListeContactAdapter;
import com.orvea.asus.orvea.Item.ListItem;

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
        checkSmsPermission();

        ls = findViewById(R.id.RecyclerView);
        ls.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        ListeContactAdapter myadpter = new ListeContactAdapter( this,Items);
        ls.setAdapter(myadpter);

        recupContact();


//        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView txtname =(TextView) view.findViewById(R.id.nom);
//                TextView numTel =(TextView) view.findViewById(R.id.num);
//
//                String num = numTel.getText().toString();
//                String msg = "Lien de l aplication";
//             try {
//                   SmsManager sms = SmsManager.getDefault();
//                    sms.sendTextMessage(num, null, msg, null, null);
//                }catch (Exception e){
//                    Toast.makeText(ListContact.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//                Toast.makeText(ListContact.this, "SMS envoiye a "+txtname.getText().toString()+"\nNum"+ num, Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    public void recupContact() {
        ContentResolver contentProvider = this.getContentResolver();
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                        ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
        if (cursor == null) {
            Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();
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



    public void checkSmsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST);
            }
        } else {
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) ==
                            PackageManager.PERMISSION_GRANTED) {

                    }
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                            MY_PERMISSIONS_REQUEST);
                }
                return;
            }
        }
    }
}
