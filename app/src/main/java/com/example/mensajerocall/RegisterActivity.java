package com.example.mensajerocall;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }

    public void Registrarse(View view){
        Intent registrarse = new Intent(this, MainActivity.class);
        startActivity(registrarse);
    }

    public void IniciarSesion(View view){
        Intent iniciarSesion = new Intent(this, LoginActivity.class);
        startActivity(iniciarSesion);
    }
}
