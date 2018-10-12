package com.orvea.asus.orvea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class InscriptionActivity extends AppCompatActivity {

    EditText Nom, Prenom, Email, Password, Tel;
    String email, password, nom, prenom, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.pass);
        Nom = findViewById(R.id.nom);
        Prenom = findViewById(R.id.prenom);
        Tel = findViewById(R.id.tel);
    }

    public void valider(View view) {
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();
        nom = Password.getText().toString().trim();
        prenom = Password.getText().toString().trim();
        tel = Password.getText().toString().trim();

        if (valider()) {
            startActivity(new Intent(this, login.class));
        }
    }

    private boolean valider() {
        boolean valide = true;
        if (nom.isEmpty()) {
            Nom.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        if (prenom.isEmpty()) {
            Prenom.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
        if (tel.isEmpty()) {
            Tel.setError(getString(R.string.champs_obligatoir));
            valide = false;
        }
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
