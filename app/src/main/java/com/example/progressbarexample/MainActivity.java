package com.example.progressbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBarLinear;
    ProgressBar progressBarCircle;
    Integer progressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressValue = 0;
        progressBarLinear = findViewById(R.id.progressBarLinear);

        progressBarCircle = findViewById(R.id.progressBarCircle);
        progressBarCircle.setVisibility(View.VISIBLE);
    }
    public void onClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<= progressBarLinear.getMax(); i++){
                   final int progress = i;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBarLinear.setProgress(progress);
                            if (progress == 100){
                                progressBarCircle.setVisibility(View.GONE);
                            }
                        }
                    });
                    try {
                        Thread.sleep(100);
                    }catch(InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        }).start();


    }
}
