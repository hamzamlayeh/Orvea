package com.orvea.asus.orvea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText Email, Password;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.passe);
    }

    public void valider(View view) {
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();

//        if (valider()) {
            startActivity(new Intent(this, ListesMembresActivity.class));

//        }
    }

    private boolean valider() {
        boolean valide = true;
        if (email.isEmpty()) {
            Email.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        if (!email.isEmpty() && (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            Email.setError(getString(R.string.email_invalide));
            valide = false;
        }
        if (password.isEmpty()) {
            Password.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        return valide;
    }
}
