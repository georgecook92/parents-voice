package com.parentsvoice.parentsvoice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parentsvoice.parentsvoice.about_us.About_Us_Activity;
import com.parentsvoice.parentsvoice.adapters.DetailPagerAdapter;

public class DetailActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private String screen_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        screen_name = intent.getStringExtra("name");
        System.out.println(screen_name);


        //top toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#ff8400"));
        setSupportActionBar(toolbar);

        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(screen_name);
        title.setTextColor(Color.parseColor("#ffffff"));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        if (!screen_name.equals("About Us")) {
            //TABS

            tabLayout.addTab(tabLayout.newTab().setText("Information"));
            tabLayout.addTab(tabLayout.newTab().setText("Safe Guarding"));
            tabLayout.addTab(tabLayout.newTab().setText("Agencies"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        } else {
            tabLayout.addTab(tabLayout.newTab().setText("About"));
            tabLayout.addTab(tabLayout.newTab().setText("Sponsors"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }


        System.out.println("Working");

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        final DetailPagerAdapter adapter = new DetailPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), screen_name);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
