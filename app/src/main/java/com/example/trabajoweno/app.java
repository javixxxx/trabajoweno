package com.example.trabajoweno;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity { /** MyActivity o como lo quieras llamar */

    Button buttonstart = (Button) this.findViewById(R.id.buttonstart);
    Button buttonstop = (Button) this.findViewById(R.id.buttonstop);

    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); /** No se como se llamara tu layout, he puesto main_activity, pero puede ser otra */
        mMediaPlayer = MediaPlayer.create(MyActivity.this,R.raw.sonido_pitido); /** El nombre lo he puesto aleatorio, tienes que poner el nombre del tuyo, MyActivity.this,R.raw.aleatorio */
        /** tienes que meter tu sonido en "app/src/main/res/raw/" */
        buttonstart.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                if (v.getId() == R.id.buttonstart) {
                    mMediaPlayer.start();
                } else (v.getId() == R.id.buttonstop) {
                    mMediaPlayer.stop();
                }
            }
        });
    }
    public void displaySeconds() {
        long startTime = System.currentTimeMillis();
        long timeElapsed = System.currentTimeMillis() - startTime;
        final String Seconds = timeElapsed / 1000;
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                TextView secondsText = (TextView) findViewById(R.id.textView);
                secondsText.setText(String.valueOf(Seconds));
            }
        });
    }
}  