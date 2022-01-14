package com.example.trabajoweno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla_Altas extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_altas); /** No se como se llamara tu layout, he puesto main_activity, pero puede ser otra */
        Button buttonstart = (Button) findViewById(R.id.buttonstart);
        Button buttonstop = (Button) findViewById(R.id.buttonstop);
        /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);*/
        mMediaPlayer = MediaPlayer.create(Pantalla_Altas.this, R.raw.sonido_pitido); /** El nombre lo he puesto aleatorio, tienes que poner el nombre del tuyo, MyActivity.this,R.raw.aleatorio */
        /** tienes que meter tu sonido en "app/src/main/res/raw/" */
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.buttonstart) {
                    mMediaPlayer.start();
                    startTime = System.currentTimeMillis();
                }
            }
        });

        buttonstop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v.getId() == R.id.buttonstop) {
                    mMediaPlayer.stop();
                    displaySeconds();
                }
            }
        });
    }

        public void displaySeconds () {
            /*long startTime = System.currentTimeMillis();*/
            long timeElapsed = System.currentTimeMillis() - startTime;
            /*final String Seconds = String.valueOf(timeElapsed / 1000);*/
            /*mMediaPlayer.release();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {*/
                    TextView secondsText = (TextView) findViewById(R.id.textView);
                    /*secondsText.setText(String.valueOf(Seconds));*/
                    if (timeElapsed > 4) secondsText.setText(getResources().getString(R.string.apto));
                    else secondsText.setText(getResources().getString(R.string.no_apto));
                }
            }/*);
        }
    }*/
