package com.example.cov_idnews.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cov_idnews.R;

import static android.text.Html.fromHtml;

public class login_admin extends AppCompatActivity {

    EditText TxUsername, TxPassword;
    Button BtnLogin;
    db_admin dbCovid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        TxUsername = (EditText)findViewById(R.id.txUsername);
        TxPassword = (EditText)findViewById(R.id.txPassword);
        BtnLogin = (Button)findViewById(R.id.btnLogin);

        dbCovid = new db_admin(this);

        BtnLogin.setOnClickListener(v -> {
            String username = TxUsername.getText().toString().trim();
            String password = TxPassword.getText().toString().trim();

            if (username.equals("admin") && password.equals("12345")){
                Toast.makeText(login_admin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(login_admin.this, halaman_admin.class));
            }else{
                Toast.makeText(login_admin.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
