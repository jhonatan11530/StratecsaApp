package com.stratecsa.app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Connectar connectar = new Connectar();
        String key = "google";
        String value = "googletest";
        connectar.get(key, value);

        EditText Correo = findViewById(R.id.correo);
        EditText Password = findViewById(R.id.password);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(LoginActivity.this, "Conectado a STRATECSA", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("NO ESTAS CONECTADO A INTERNET");
            builder.setMessage("Porfavor verifica la conexion a internet");
            builder.setPositiveButton("ACEPTAR", (dialogInterface, i) -> {

            });
            AlertDialog alert = builder.create();
            alert.show();
            alert.setCanceledOnTouchOutside(false);
        }

        Button Login = findViewById(R.id.login);
        Login.setOnClickListener(v -> {
            if (Correo.getText().toString().equals("a") && Password.getText().toString().equals("a")) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
            }
        });
    }
}