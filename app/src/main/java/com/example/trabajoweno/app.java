package com.example.trabajoweno;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class app extends AppCompatActivity { /** MyActivity o como lo quieras llamar */
    
    public void setMaxVolume(Context mContext) {
        AudioManager am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
    }

    Button buttonstart = (Button) this.findViewById(R.id.buttonstart);
    Button buttonstop = (Button) this.findViewById(R.id.buttonstop);
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_altas); /** No se como se llamara tu layout, he puesto main_activity, pero puede ser otra */
        mMediaPlayer = MediaPlayer.create(app.this,R.raw.sonido_pitido); /** El nombre lo he puesto aleatorio, tienes que poner el nombre del tuyo, MyActivity.this,R.raw.aleatorio */
        /** tienes que meter tu sonido en "app/src/main/res/raw/" */
        buttonstart.setOnClickListener(new View.OnClickListener(){

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
                    displaySeconds();
                }
            }
        });

    }
    public void displaySeconds() {
        long startTime = System.currentTimeMillis();
        long timeElapsed = System.currentTimeMillis() - startTime;
        final String Seconds = String.valueOf(timeElapsed / 1000);
        mMediaPlayer.release();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                TextView secondsText = (TextView) findViewById(R.id.textView);
                /*secondsText.setText(String.valueOf(Seconds));*/
                if(timeElapsed>4) secondsText.setText("@string/apto");
                else secondsText.setText("@string/no_apto");
            }
        });
    }
}  