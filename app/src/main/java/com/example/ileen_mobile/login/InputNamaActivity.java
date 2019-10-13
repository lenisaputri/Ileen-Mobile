package com.example.ileen_mobile.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ileen_mobile.MainActivity;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;

public class InputNamaActivity extends AppCompatActivity {

    private EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);

        nameInput = findViewById(R.id.input_name);
    }

    public void menuKlik(View view) {

        String name = nameInput.getText().toString();

        if(name.isEmpty() || name.length() == 0 || name.equals("") || name == null){
            Toast.makeText(this, "please enter your name ", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(InputNamaActivity.this, PlayActivity.class);
            startActivity(i);
        }
    }
}
