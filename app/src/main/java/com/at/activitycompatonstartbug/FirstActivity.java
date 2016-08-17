package com.at.activitycompatonstartbug;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Alexander Thiele (kontakt@alexander-thiele.de)
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        // just wait a few seconds and then start another activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // this will trigger the onStop from MainActivity
                Intent startIntent = new Intent(FirstActivity.this, SecondActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(FirstActivity.this);
                ActivityCompat.startActivity(FirstActivity.this, startIntent, options.toBundle());
            }
        }, 5000);
    }
}
