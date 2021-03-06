package ru.startandroid1.taximanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ru.startandroid1.taximanager.R;
import ru.startandroid1.taximanager.adapter.TabsPagerFragmentAdapterDriver;

public class DriverActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvDriverActivityLogin, tvDriverActivityName;
    private ViewPager viewPagerDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();

        tvDriverActivityLogin = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvDriverActivityLogin);
        tvDriverActivityName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvDriverActivityName);

        tvDriverActivityLogin.setText(intent.getStringExtra("LALogin"));
        tvDriverActivityName.setText(intent.getStringExtra("LAName"));

        initTabs();
    }

    private void initTabs() {
        viewPagerDriver = (ViewPager)findViewById(R.id.viewPagerDriver);
        TabsPagerFragmentAdapterDriver adapter = new TabsPagerFragmentAdapterDriver(getSupportFragmentManager());
        viewPagerDriver.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayoutDriver);
        tabLayout.setupWithViewPager(viewPagerDriver);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.driver, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_driver_profile) {

        } else if (id == R.id.nav_driver_tools) {

        } else if (id == R.id.nav_new_transportations) {
            viewPagerDriver.setCurrentItem(0);
        } else if (id == R.id.nav_current_transportation) {
            viewPagerDriver.setCurrentItem(1);
        } else if (id == R.id.nav_all_transportations) {
            viewPagerDriver.setCurrentItem(2);
        } else if (id == R.id.nav_send_message) {
            viewPagerDriver.setCurrentItem(3);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
