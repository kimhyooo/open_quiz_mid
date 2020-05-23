package com.example.ansys.hahahaha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.ansys.hahahaha.activity_version_quiz.version_see;

public class activity_version_ranker extends AppCompatActivity {

    Button version_btn1 ,version_btn2, version_btn3, version_btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_ranker);
        version_btn1 = findViewById(R.id.version_btn1);
        version_btn2 = findViewById(R.id.version_btn2);
        version_btn3 = findViewById(R.id.version_btn3);
        version_btn4 = findViewById(R.id.version_btn4);

        version_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                version_see=0;
                Intent intent = new Intent(activity_version_ranker.this, activity_ranker.class);
                startActivity(intent);
                finish();
            }
        });
        version_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                version_see=1;
                Intent intent = new Intent(activity_version_ranker.this, activity_ranker.class);
                startActivity(intent);
                finish();
            }
        });
        version_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                version_see=2;
                Intent intent = new Intent(activity_version_ranker.this, activity_ranker.class);
                startActivity(intent);
                finish();
            }
        });
        version_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_version_ranker.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
