package com.example.trabajoweno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Pantalla_Altas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_altas); /** No se como se llamara tu layout, he puesto main_activity, pero puede ser otra */
        Button buttonstart = (Button) findViewById(R.id.buttonstart);
        Button buttonstop = (Button) findViewById(R.id.buttonstop);
        /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);*/
        MediaPlayer mMediaPlayer = MediaPlayer.create(Pantalla_Altas.this, R.raw.sonido_pitido); /** El nombre lo he puesto aleatorio, tienes que poner el nombre del tuyo, MyActivity.this,R.raw.aleatorio */
        /** tienes que meter tu sonido en "app/src/main/res/raw/" */
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.buttonstart) {
                    mMediaPlayer.start();
                }
            }
        });

        buttonstop.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if (v.getId() == R.id.buttonstop) {
                    mMediaPlayer.stop();
                    /*displaySeconds();*/
                }
            }
        });
    }
}