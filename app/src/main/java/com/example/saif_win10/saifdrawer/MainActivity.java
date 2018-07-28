package com.example.saif_win10.saifdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saif_win10.saifdrawer.Fragment.FragmentFour;
import com.example.saif_win10.saifdrawer.Fragment.FragmentOne;
import com.example.saif_win10.saifdrawer.Fragment.FragmentThree;
import com.example.saif_win10.saifdrawer.Fragment.FragmentTwo;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentOne()).commit();

            navigationView.setCheckedItem(R.id.nav_partOne);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_partOne:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentOne()).commit();

                break;
            case R.id.nav_partTwo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentTwo()).commit();
                break;
            case R.id.nav_partThree:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentThree()).commit();
                break;
            case R.id.nav_partFour:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentFour()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share this app", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send a message", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
