package com.example.cov_idnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelpTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_tab);

    }

    public void clikback3(View view) {
        Intent intent = new Intent(HelpTab.this, MainActivity.class);
        startActivity(intent);
    }
}