package com.example.ileen_mobile.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ileen_mobile.MainActivity;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;

public class InputNamaActivity extends AppCompatActivity {

    Dialog myDialog;

    private EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);
        myDialog = new Dialog(this);

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

        MediaPlayer mp = MediaPlayer.create(InputNamaActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();
    }

    public void ShowPopupNama(View view) {
        ImageView close_icon;
        myDialog.setContentView(R.layout.setting_popup);
        close_icon =(ImageView) myDialog.findViewById(R.id.close_icon);
        close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        MediaPlayer mp = MediaPlayer.create(InputNamaActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
