package com.example.cov_idnews.rumahsakit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.example.cov_idnews.R;
import com.example.cov_idnews.model.RumahSakit;
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

import com.example.cov_idnews.R;
import com.example.cov_idnews.model.RumahSakit;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtNama, edtAlamat;

    private Button btnSave;
//    private ImageView imageView;

    private Uri filePath;

    private final int PICK_IMAGE_REQUEST = 71;

    private RumahSakit rumahSakit;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hospital);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtNama = findViewById(R.id.edtNama);
        edtAlamat = findViewById(R.id.edtAlamat);
//        imageView = findViewById(R.id.imageView);
//        btnChoose = findViewById(R.id.btnChoose);
//        btnChoose.setOnClickListener(this);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
//        btnListRs = findViewById(R.id.btnListViewRS);
//        btnListRs.setOnClickListener(this);

        rumahSakit = new RumahSakit();
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnSave) {
            saveRumahSakit();
        }
//        if (view.getId() == R.id.btnChoose) {
//            chooseImage();
//        }
//        if (view.getId() == R.id.btnListViewRS) {
////            Intent intent = new Intent(CreateActivity.this, ListActivity.class);
////            startActivity(intent);
//        }


    }

//
//    private void chooseImage() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
//                && data != null && data.getData() != null )
//        {
//            filePath = data.getData();
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
//                imageView.setImageBitmap(bitmap);
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }

    private void saveRumahSakit()
    {
        String nama = edtNama.getText().toString().trim();
        String alamat = edtAlamat.getText().toString().trim();


        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(nama)) {
            isEmptyFields = true;
            edtNama.setError("Field ini tidak boleh kosong");
        }

        if (TextUtils.isEmpty(alamat)) {
            isEmptyFields = true;
            edtAlamat.setError("Field ini tidak boleh kosong");
        }

        if (! isEmptyFields) {

            Toast.makeText(CreateActivity.this, "Saving Data...", Toast.LENGTH_SHORT).show();

            DatabaseReference dbRumahSakit = mDatabase.child("rumahsakit");

            String id = dbRumahSakit.push().getKey();
            rumahSakit.setId(id);
            rumahSakit.setNama(nama);
            rumahSakit.setAlamat(alamat);

            //insert data
            dbRumahSakit.child(id).setValue(rumahSakit);

            finish();

        }
    }


//    public void ListRumahsakit(View view) {
//        Intent intent = new Intent(CreateActivity.this, ListActivity.class);
//        startActivity(intent);
//    }
}