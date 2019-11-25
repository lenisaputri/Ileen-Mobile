package com.example.ileen_mobile.practice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TwoActivity extends AppCompatActivity {
    private TextView Label;
    private TextView questionLabel;
    private ImageView imageView;
    private Button jawaban1;
    private Button jawaban2;
    private Button jawaban3;
    private Button jawaban4;


    private String jawabanBenar;
    private int jawabanBenarLabel = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();



    String quizData[][] =  {
            {"A: What do you want to eat ? \n B: __________","Pizza","Ice Cream","Milk","Juice"},
            {"A: What do you want to drink ? \n B: __________","Milk","Rice","Orange","Bread"},
            {"The number after eighteen is...","Nineteen","Seventeen","Sixteen","Twenty"},
            {"Ten multiple by five (10 x 5) is ...","Fifty","Five","Fifty five","Fifteen"},
            {"Soto, nasi goreng, and rice are kinds of ...","Food","Drink","Vegetables","Fruit"},
            {"I like to eat ... for breakfast.","Bread","Juice","Milk","Ice Cream"},
            {"The baby drinks a bottle of ...","Milk","Juice","Soda","Coffee"},
            {"This book cost is fifteen thousand rupiahs ...","Rp. 15.000","Rp. 50.000","Rp. 55.000","Rp. 25.000"},
            {"Seven thousand and five hundred ...","7500","75","75000","750"},
            {"Milk, juice, and coffee are kinds of ... ","Drink","Food","Fruit","Vegetables"},


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Label = (TextView)findViewById(R.id.Label);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        imageView = (ImageView)findViewById(R.id.soal);
        jawaban1 = (Button)findViewById(R.id.jawaban1);
        jawaban2 = (Button)findViewById(R.id.jawaban2);
        jawaban3 = (Button)findViewById(R.id.jawaban3);
        jawaban4 = (Button)findViewById(R.id.jawaban4);


        for (int i = 0; i < quizData.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {
        Label.setText("Q" + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> ganda = quizArray.get(randomNum);

        questionLabel.setText(ganda.get(0));
        jawabanBenar = ganda.get(1);

        ganda.remove(0);
        Collections.shuffle(ganda);

        jawaban1.setText(ganda.get(0));
        jawaban2.setText(ganda.get(1));
        jawaban3.setText(ganda.get(2));
        jawaban4.setText(ganda.get(3));

        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view){
        Button btnJawab = (Button) findViewById(view.getId());
        String btnNext = btnJawab.getText().toString();

        String alertTitle;

        if(btnNext.equals(jawabanBenar)){
            alertTitle = "Right";
            jawabanBenarLabel=jawabanBenarLabel+10;
        }else {
            alertTitle = "False";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Jawaban : " + jawabanBenar);
        builder.setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (quizCount == QUIZ_COUNT){
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("JAWABAN_BENAR_LABEL", jawabanBenarLabel);
                    startActivity(intent);
                }else {
                    quizCount++;
                    showNextQuiz();

                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}
