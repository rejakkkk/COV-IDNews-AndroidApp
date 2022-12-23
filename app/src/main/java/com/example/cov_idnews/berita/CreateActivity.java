package com.example.cov_idnews.berita;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cov_idnews.R;
import com.example.cov_idnews.model.RumahSakit;
import com.google.firebase.database.FirebaseDatabase;

public class CreateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
    }
}
