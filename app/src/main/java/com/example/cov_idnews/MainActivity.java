package com.example.cov_idnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;


import com.example.cov_idnews.admin.login_admin;
import com.example.cov_idnews.berita.NewsTab;
import com.example.cov_idnews.rumahsakit.HospitalTab;
import com.example.cov_idnews.admin.halaman_admin;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void help(View view) {
        Intent intent = new Intent(MainActivity.this, HelpTab.class);
        startActivity(intent);
    }



    public void our_team(View view) {
        Intent intent = new Intent(MainActivity.this, OurTeam.class);
        startActivity(intent);
    }


    public void news(View view) {
        Intent intent = new Intent(MainActivity.this, NewsTab.class);
        startActivity(intent);
    }

    public void hospital(View view) {
        Intent intent = new Intent(MainActivity.this, HospitalTab.class);
        startActivity(intent);
    }

    public void loginAdmin(View view) {
        Intent intent = new Intent(MainActivity.this, login_admin.class);
        startActivity(intent);
    }
}