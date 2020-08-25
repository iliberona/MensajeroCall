package com.example.mensajerocall;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telecom.Call;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mensajerocall.Controller.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3, tab4;

    PagerController pagerController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setIcon(R.mipmap.ic_app);
        actionBar.setDisplayShowHomeEnabled(true);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tab1 = findViewById(R.id.tabContactos);
        tab2 = findViewById(R.id.tabLlamadas);
        tab3 = findViewById(R.id.tabMensajes);
        tab4 = findViewById(R.id.tabPerfil);

        pagerController = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerController);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0){
                    pagerController.notifyDataSetChanged();
                }
                if (tab.getPosition() == 1){
                    pagerController.notifyDataSetChanged();
                }
                if (tab.getPosition() == 2){
                    pagerController.notifyDataSetChanged();
                }
                if (tab.getPosition() == 3){
                    pagerController.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item1:
                Toast mensaje = Toast.makeText(getApplicationContext(),"Estamos trabajando para usted", Toast.LENGTH_SHORT);
                mensaje.show();
                break;
            case R.id.item2:
                finishAffinity();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void onClickLlamada(View v) {
        Intent llamada = new Intent(Intent.ACTION_DIAL);
        startActivity(llamada);
    }

    public void onClickCamara(View v) {
        Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camara);
    }

    public void onClickContacto(View v) {
        viewPager.setCurrentItem(3);
    }

    public void onClickMensaje(View v) {
        viewPager.setCurrentItem(2);
    }

    public void onClickEnviarMensaje(View v) {

        EditText editText = findViewById(R.id.editTextMensaje);
        String text = editText.getText().toString();

        if(!text.equals("")){
            LinearLayout layout = (LinearLayout)findViewById(R.id.layout_mensajes);
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setBackground(getResources().getDrawable(R.drawable.shape_mensajes));
            layoutParams.setMargins(0,15, 15,0);
            linearLayout.setLayoutParams(layoutParams);

            TextView tv = new TextView(this);
            layoutParams.setMargins(10,10, 0,0);
            tv.setLayoutParams(layoutParams);
            tv.setText(text);
            tv.setTextColor(Color.WHITE);
            linearLayout.addView(tv);

            TextView tv2 = new TextView(this);
            layoutParams.setMargins(0,5, 10,5);
            tv2.setGravity(Gravity.RIGHT);
            tv2.setLayoutParams(layoutParams);
            tv2.setText("23:32");
            tv2.setTextColor(Color.WHITE);
            linearLayout.addView(tv2);

            layout.addView(linearLayout);

            Toast mensaje = Toast.makeText(getApplicationContext(),"Mensaje enviado", Toast.LENGTH_SHORT);
            mensaje.show();
        } else {
            Toast mensaje = Toast.makeText(getApplicationContext(),"Escriba su mensaje", Toast.LENGTH_SHORT);
            mensaje.show();
        }

    }
}
