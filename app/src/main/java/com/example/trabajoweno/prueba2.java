package com.example.trabajoweno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class prueba2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba2);
        Button comenzar = (Button) findViewById(R.id.boton1);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent comenzar = new Intent(prueba2.this, pantallaFrecuencias.class);
                startActivity(comenzar);

            }
        });
    }
}