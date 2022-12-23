package com.example.cov_idnews.rumahsakit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.example.cov_idnews.R;
import com.example.cov_idnews.adapter.RumahSakitAdapter;
import com.example.cov_idnews.model.RumahSakit;
import com.example.cov_idnews.rumahsakit.CreateActivity;
import com.example.cov_idnews.rumahsakit.UpdateActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private Button btnAdd;

    private RumahSakitAdapter adapter;
    private ArrayList<RumahSakit> rumahsakitList;
    DatabaseReference dbRumahsakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hospital_admin);

        dbRumahsakit = FirebaseDatabase.getInstance().getReference("rumahsakit");

        listView = findViewById(R.id.lvList);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        rumahsakitList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this, UpdateActivity.class);
                intent.putExtra(UpdateActivity.EXTRA_RUMAHSAKIT, rumahsakitList.get(i));

                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            Intent intent = new Intent(ListActivity.this, CreateActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        dbRumahsakit.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rumahsakitList.clear();

                for (DataSnapshot rumahsakitSnapshot : dataSnapshot.getChildren()) {
                    RumahSakit rumahSakit = rumahsakitSnapshot.getValue(RumahSakit.class);
                    rumahsakitList.add(rumahSakit);
                }

                RumahSakitAdapter adapter = new RumahSakitAdapter(ListActivity.this);
                adapter.setRumahSakitList(rumahsakitList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ListActivity.this, "Terjadi kesalahan.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
