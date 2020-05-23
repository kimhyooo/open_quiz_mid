package com.example.ansys.hahahaha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_other extends AppCompatActivity {
    public static DatabaseHelper questionDBHelper;
    private final int SET_QUIZ = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        questionDBHelper = new DatabaseHelper(this, "quiz", null, 1);
    }

    public void goQuiz(View v){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void onSetting(View v){

        startActivity(new Intent(this, activity_ps.class));
    }
}

