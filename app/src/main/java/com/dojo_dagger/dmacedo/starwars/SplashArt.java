package com.dojo_dagger.dmacedo.starwars;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashArt extends AppCompatActivity {

    private static final int progress = 0;

    private ProgressBar progressBar;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_art);

        progressBar = (ProgressBar) findViewById(R.id.pb_splashArt);

        new Thread(new Runnable() {

            int i = 0;

            public void run() {
                while (i < 100) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    mHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(i);
                            i++;
                        }
                    });
                }
                Intent intent = new Intent(SplashArt.this, MainActivity.class);
                startActivity(intent);
            }

        }).start();

    }

    }

