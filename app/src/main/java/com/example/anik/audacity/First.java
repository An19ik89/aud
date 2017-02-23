package com.example.anik.audacity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import java.util.Random;
public class First extends Activity{

    Thread splashTread;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstscreen);
        imageView = (ImageView)findViewById(R.id.firstscreenimage);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int ids = R.drawable.begin;
        this.imageView.setImageDrawable(getResources().getDrawable(ids));

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(First.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    First.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    First.this.finish();
                }

            }
        };
        splashTread.start();
    }

}
