package com.example.cov_idnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cov_idnews.berita.NewsTab;

public class OurTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);
    }

    public void clikback2(View view) {
        Intent intent = new Intent(OurTeam.this, MainActivity.class);
        startActivity(intent);
    }
}