package com.example.cov_idnews.rumahsakit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cov_idnews.R;
import com.example.cov_idnews.model.RumahSakit;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNama, edtAlamat;
    private Button btnUpdate,btnDelete;

    public static final String EXTRA_RUMAHSAKIT = "extra_rumahsakit";
    public final int ALERT_DIALOG_CLOSE = 10;
    public final int ALERT_DIALOG_DELETE = 20;

    private RumahSakit rumahsakit;
    private String rumahsakitId;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hospital);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtNama = findViewById(R.id.edtEditNama);
        edtAlamat = findViewById(R.id.edtEditAlamat);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        rumahsakit = getIntent().getParcelableExtra(EXTRA_RUMAHSAKIT);

        if (rumahsakit != null) {
            rumahsakitId = rumahsakit.getId();
        } else {
            rumahsakit = new RumahSakit();
        }

        if (rumahsakit != null) {
            edtNama.setText(rumahsakit.getNama());
            edtAlamat.setText(rumahsakit.getAlamat());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Edit Data");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUpdate) {
            updateRumahSakit();
        }
        if (v.getId() == R.id.btnDelete) {
            deleteRumahSakit();
        }
    }

    private void updateRumahSakit() {
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

            Toast.makeText(UpdateActivity.this, "Updating Data...", Toast.LENGTH_SHORT).show();

            rumahsakit.setNama(nama);
            rumahsakit.setAlamat(alamat);

            DatabaseReference dbRumahsakit = mDatabase.child("rumahsakit");

            //update data
            dbRumahsakit.child(rumahsakitId).setValue(rumahsakit);

            finish();
        }
    }

    public void deleteRumahSakit(){
        DatabaseReference dbRumahsakit =
                mDatabase.child("rumahsakit").child(rumahsakitId);

        dbRumahsakit.removeValue();

        Toast.makeText(UpdateActivity.this, "Deleting data...",
                Toast.LENGTH_SHORT).show();

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //pilih menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                showAlertDialog(ALERT_DIALOG_DELETE);
                break;
            case android.R.id.home:
                showAlertDialog(ALERT_DIALOG_CLOSE);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //HAPUS DATA


    @Override
    public void onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE);
    }

    private void showAlertDialog(int type) {
        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
        String dialogTitle, dialogMessage;

        if (isDialogClose) {
            dialogTitle = "Batal";
            dialogMessage = "Apakah anda ingin membatalkan perubahan pada form?";
        } else {
            dialogTitle = "Hapus Data";
            dialogMessage = "Apakah anda yakin ingin menghapus item ini?";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(dialogTitle);
        alertDialogBuilder.setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (isDialogClose) {
                            finish();
                        } else {
                            //kode hapus data masuk disini
                            if (isDialogClose) {
                                finish();
                            } else {
                                //hapus data
                                DatabaseReference dbRumahsakit =
                                        mDatabase.child("rumahsakit").child(rumahsakitId);

                                dbRumahsakit.removeValue();

                                Toast.makeText(UpdateActivity.this, "Deleting data...",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
