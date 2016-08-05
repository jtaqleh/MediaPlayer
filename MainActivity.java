package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Global variable
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * DO NOT name your raw file with capital letters!!!*/
        mediaPlayer = MediaPlayer.create(this, R.raw.any_given_sunday);

        //ClickListener for the play button
        Button playButton = (Button) findViewById(R.id.play_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The toast message is just used to test if the onClick works
                //Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                //Method that will notify us when the song is done playing
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer){
                        //Toast message to notify us
                        Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //ClickListener for the pause button
        Button pauseButton = (Button) findViewById(R.id.pause_button);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The toast message is just used to test if the onClick works
                //Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

    }
}
