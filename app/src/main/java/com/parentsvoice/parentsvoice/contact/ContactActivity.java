package com.parentsvoice.parentsvoice.contact;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parentsvoice.parentsvoice.DetailActivity;
import com.parentsvoice.parentsvoice.R;

/**
 * Created by georgecook on 05/07/16.
 */
public class ContactActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        //top toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#ff8400"));
        setSupportActionBar(toolbar);

        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("Contact Us");
        title.setTextColor(Color.parseColor("#ffffff"));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //TextView gangTitle = (TextView) inflatedView.findViewById(R.id.gang_title);
        //final SpannableStringBuilder gangTitleString = new SpannableStringBuilder( getString(R.string.gang_title) );
        //final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        //gangTitleString.setSpan(bss, 0, 20, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        //gangTitle.setText(gangTitleString);






        TextView contactEmailTitle = (TextView) findViewById(R.id.contact_email_title);
        final SpannableStringBuilder contactEmailString = new SpannableStringBuilder( getString(R.string.contact_email_title) );
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        contactEmailString.setSpan(bss,0,8,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        contactEmailTitle.setText(contactEmailString);

        TextView contactEmail = (TextView) findViewById(R.id.contact_email);
        contactEmail.setText(Html.fromHtml(getString(R.string.contact_email)));
        contactEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"parentsvoice526@gmail.com"});
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ContactActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });



        TextView contactNumberTitle = (TextView) findViewById(R.id.contact_number_title);
        final SpannableStringBuilder contactNumberString = new SpannableStringBuilder( getString(R.string.contact_number_title) );
        contactNumberString.setSpan(bss, 0, 8, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        contactNumberTitle.setText(contactNumberString);

        TextView contactNumber = (TextView) findViewById(R.id.contact_number);
        contactNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("02072544732");
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.gang_affiliation) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", "Gang Affiliation");
            startActivity(intent);
        } else if (id == R.id.dom_violence) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", "Domestic Abuse");
            startActivity(intent);
        } else if (id == R.id.sex_exploit) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", "Sexual Exploitation");
            startActivity(intent);
        } else if (id == R.id.cannabis_health) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", "Cannabis & Mental Health");
            startActivity(intent);
        } else if (id == R.id.about_us) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", "About Us");
            startActivity(intent);

        } else if (id == R.id.contact_us) {
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void call(String number) {

        String uri = "tel:" + number.trim();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);

    }

}
