package com.example.cov_idnews.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cov_idnews.MainActivity;
import com.example.cov_idnews.R;
import com.example.cov_idnews.berita.AddNews;
import com.example.cov_idnews.berita.CreateActivity;
import com.example.cov_idnews.rumahsakit.ListActivity;
import com.google.android.material.navigation.NavigationView;

public class halaman_admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button Logout;
    private ImageView AddHospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_admin);

        DrawerLayout drawerLayout = findViewById(R.id.DrawerLayoutt);

        findViewById(R.id.ImageNavigation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.NavigationView);
        navigationView.setItemIconTintList(null);

        AppBarConfiguration mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.LogOut)
                .setDrawerLayout(drawerLayout)
                .build();


        Logout = (Button) findViewById(R.id.btnExit);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(halaman_admin.this, "Logout Berhasil", Toast.LENGTH_SHORT).show();

            }
        });

//        AddHospital = (ImageView) findViewById(R.id.AddHospital);
//        AddHospital.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.AddHospital) {
//                    Intent intent = new Intent(halaman_admin.this, CreateActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//
    }


    public void TambahBerita(View view) {
        Intent intent = new Intent(halaman_admin.this, CreateActivity.class);
        startActivity(intent);
    }

    public void TambahRumahSakit(View view) {
        Intent intent = new Intent(halaman_admin.this, ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed () {
        DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.DrawerLayoutt);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.LogOut){
            startActivity(new Intent(halaman_admin.this, login_admin.class));
        }
        DrawerLayout drawerLayout =(DrawerLayout) findViewById(R.id.DrawerLayoutt);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
