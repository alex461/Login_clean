package com.alex.app_clean.login.view;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.alex.app_clean.R;

public class Create_account extends AppCompatActivity {

    private static final String TAG = "Creeate_account" ;

    private Button btnJoinUs;
    private TextInputEditText edEmail,edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);
        cast();

    }

    private void cast() {
        btnJoinUs=findViewById(R.id.btcreate2);
        edEmail=findViewById(R.id.tvC1Id);
        edPass=findViewById(R.id.tvC4Id);
    }

    private void showToolbar(String tittle,Boolean upButton) {
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
