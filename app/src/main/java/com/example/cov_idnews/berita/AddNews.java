package com.example.cov_idnews.berita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.example.cov_idnews.R;
import com.example.cov_idnews.model.Berita;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cov_idnews.berita.ListActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

public class AddNews extends AppCompatActivity implements View.OnClickListener{

    private EditText edtJudul, edtIsiBerita,edtPenulis;

    private Button btnPilihKategori,btnSaveBerita;

    private Berita berita;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtJudul = findViewById(R.id.edtJudul);
        edtIsiBerita = findViewById(R.id.edtIsiBerita);
        edtPenulis = findViewById(R.id.edtPenulis);
        btnPilihKategori = findViewById(R.id.btnPilihKategori);
        btnPilihKategori.setOnClickListener(this);
        btnSaveBerita = findViewById(R.id.btnSaveBerita);
        btnSaveBerita.setOnClickListener(this);

        berita = new Berita();
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnSave) {
            saveBerita();
        }




    }



    private void saveBerita()
    {
        String judul = edtJudul.getText().toString().trim();
        String penulis = edtPenulis.getText().toString().trim();
        String isiBerita = edtIsiBerita.getText().toString().trim();


        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(judul)) {
            isEmptyFields = true;
            edtJudul.setError("Field ini tidak boleh kosong");
        }
        if (TextUtils.isEmpty(isiBerita)) {
            isEmptyFields = true;
            edtPenulis.setError("Field ini tidak boleh kosong");
        }


        if (TextUtils.isEmpty(isiBerita)) {
            isEmptyFields = true;
            edtIsiBerita.setError("Field ini tidak boleh kosong");
        }


        if (! isEmptyFields) {

            Toast.makeText(com.example.cov_idnews.berita.AddNews.this, "Saving Data...", Toast.LENGTH_SHORT).show();

            DatabaseReference dbBerita = mDatabase.child("berita");

            String id = dbBerita.push().getKey();
            berita.setId(id);
            berita.setJudul(judul);
            berita.setJudul(penulis);
            berita.setIsiBerita(isiBerita);

            //insert data
            dbBerita.child(id).setValue(berita);

            finish();

        }
    }

    public void ListBerita(View view) {
        Intent intent = new Intent(com.example.cov_idnews.berita.AddNews.this, ListActivity.class);
        startActivity(intent);
    }


}