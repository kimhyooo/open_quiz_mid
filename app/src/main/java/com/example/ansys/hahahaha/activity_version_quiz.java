package com.example.ansys.hahahaha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_version_quiz extends AppCompatActivity {
    public static int hint_see = 0; //힌트 구분하기 위한

    Button version_btn1 ,version_btn2, version_btn3, version_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_quiz);
        version_btn1 = findViewById(R.id.version_btn1);
        version_btn2 = findViewById(R.id.version_btn2);
        version_btn3 = findViewById(R.id.version_btn3);
        version_btn4 = findViewById(R.id.version_btn4);
    }
    public void hard_start1(View view){
        Intent intent = new Intent(activity_version_quiz.this, activity_quiz.class);
        hint_see = 0; // 힌트 안 보임
        startActivity(intent);
    }

    public void normal_start1(View view){
        Intent intent = new Intent(activity_version_quiz.this, activity_quiz.class);
        startActivity(intent);
        hint_see = 0; // 힌트 안 보임
    }

    public void easy_start1(View view){
        Intent intent = new Intent(activity_version_quiz.this, activity_quiz.class);
        startActivity(intent);
        hint_see = 1; //힌트 보임
    }

    public void mix_start1(View view){
        Intent intent = new Intent(activity_version_quiz.this, activity_open_quiz.class);
        startActivity(intent);
    }
}
