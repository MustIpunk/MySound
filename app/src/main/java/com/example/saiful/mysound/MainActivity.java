package com.example.saiful.mysound;

import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    Button btnPlay;

    SoundPool sp;
    int soundInd;
    boolean spLoad = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(myListener);

        sp = new SoundPool.Builder()
                .setMaxStreams(10)
                .build();

        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0) {
                    spLoad = true;
                } else {
                    Toast.makeText(MainActivity.this, "Gagal Load", Toast.LENGTH_SHORT).show();

                }
            }
        });
        soundInd = sp.load(this, R.raw.clinking_glasses, 1);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (spLoad) {
                sp.play(soundInd, 1, 1, 0, 1, 1);
            }


        }
    };

}
