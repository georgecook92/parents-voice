package com.parentsvoice.parentsvoice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private static boolean splashLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (!splashLoaded) {
            setContentView(R.layout.activity_start);
            int secondsDelayed = 4;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(StartActivity.this, DetailActivity.class);
                    intent.putExtra("name", "Gang Affiliation");
                    startActivity(intent);

                }
            }, secondsDelayed * 500);

            splashLoaded = true;
        }
        else {
            Intent intent = new Intent(StartActivity.this, DetailActivity.class);
            intent.putExtra("name", "Gang Affiliation");
            startActivity(intent);
        }




    }


}
