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

public class FiveActivity extends AppCompatActivity {

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
            {"What is the weather today ? we using umbrella ?","It is rainy","It is foggy","It is windy","It is sunny"},
            {"In England we have four season are...","Summer,authumn,winter,spring","Summer,authumn,spring,rainy","Summer,authumn,spring,dry","Summer,authumn,spring,season"},
            {"There are season in indonesia, they are ...","Rainy and dry","Summer and winter","Wet and snowy","Authumn and spring"},
            {"Twenty degrees Fahrenheit in the number is ...","20ºF","22ºF","12ºF","21ºC"},
            {"We can see water falling from the sky at ?","Rainy","Sunny","Summer","Dry Season"},
            {"We can see snow in the ...","Winter","Spring","Summer","Autumn"},
            {"Don’t forget to bring...in dry season","Hat","Jacket","Gloves","Sock"},
            {"Jhon is tall but sardi is ...","Short","Long","Small","Beautifull"},
            {"Keep ...My baby is sleeping.","Silent","Noisy","Crying","Standing"},
            {"Kuda in English?","Horse","Chicken","Goat","Elephant"},


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

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
