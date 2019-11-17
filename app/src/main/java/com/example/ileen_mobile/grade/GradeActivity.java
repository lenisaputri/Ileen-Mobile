package com.example.ileen_mobile.grade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class GradeActivity extends AppCompatActivity {
    //instansiasi Recyclerview
    RecyclerView rvGrade;
    //instansiasi list superhero
    List<Grade> listGrade = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        rvGrade = findViewById(R.id.rvGrade);
        Grade grade = new Grade(this.getResources().getDrawable(R.drawable.one),"80","8/10");
        listGrade.add(grade);
        grade = new Grade(this.getResources().getDrawable(R.drawable.two),"80","8/10");
        listGrade.add(grade);
        grade = new Grade(this.getResources().getDrawable(R.drawable.three),"80","8/10");
        listGrade.add(grade);
        grade = new Grade(this.getResources().getDrawable(R.drawable.four),"80","8/10");
        listGrade.add(grade);
        grade = new Grade(this.getResources().getDrawable(R.drawable.five),"80","8/10");
        listGrade.add(grade);

        GradeAdapter gradeAdapter = new GradeAdapter(listGrade);
        rvGrade.setAdapter(gradeAdapter);
        rvGrade.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
