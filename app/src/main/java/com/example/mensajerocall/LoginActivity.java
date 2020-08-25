package com.example.mensajerocall;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }

    public void IniciarSesion(View view){
        Intent iniciarSesion = new Intent(this, MainActivity.class);
        startActivity(iniciarSesion);
    }

    public void Registrarse(View view){
        Intent registrarse = new Intent(this, RegisterActivity.class);
        startActivity(registrarse);
    }
}
