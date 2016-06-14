package com.parentsvoice.parentsvoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parentsvoice.parentsvoice.about_us.About_Us_Activity;

public class OptionsActivity extends AppCompatActivity {

    private Button gang_btn;
    private Button dom_violence_btn;
    private Button sexual_exploitation_btn;
    private Button cannabis_btn;
    private Button about_us_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("Parents Voice");

        gang_btn = (Button)findViewById(R.id.gang_button);
        dom_violence_btn = (Button) findViewById(R.id.violence_button);
        sexual_exploitation_btn = (Button) findViewById(R.id.exploitation_button);
        cannabis_btn = (Button) findViewById(R.id.cannabis_button);
        about_us_button = (Button) findViewById(R.id.about_us_btn);

        clickListener(gang_btn, "Gang Affiliation");
        clickListener(dom_violence_btn, "Domestic Violence");
        clickListener(sexual_exploitation_btn, "Sexual Exploitation");
        clickListener(cannabis_btn, "Cannabis & Mental Health");

        about_us_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, About_Us_Activity.class);
                startActivity(intent);
            }
        });

    }

    private void clickListener(Button btn, final String page_title  ) {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, DetailActivity.class);
                intent.putExtra("name", page_title);
                startActivity(intent);
            }
        });

    }

}
