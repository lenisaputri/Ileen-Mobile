package com.example.ileen_mobile.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ileen_mobile.MainActivity;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;

public class InputNamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);
    }

    public void menuKlik(View view) {
        Intent i = new Intent(InputNamaActivity.this, MenuActivity.class);
        startActivity(i);
    }
}
