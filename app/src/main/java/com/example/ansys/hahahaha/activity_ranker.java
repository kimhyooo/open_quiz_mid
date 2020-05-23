package com.example.ansys.hahahaha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.ansys.hahahaha.activity_version_quiz.version_see;

public class activity_ranker extends AppCompatActivity {

    TextView hard_title, hard_rank;
    Button re_btn;
    String best1_n_h, best2_n_h, best3_n_h, best1_n_n, best2_n_n, best3_n_n, best1_n_e, best2_n_e, best3_n_e;
    int best1_s_h, best2_s_h, best3_s_h, best1_s_n, best2_s_n, best3_s_n, best1_s_e, best2_s_e, best3_s_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranker);

        hard_title = (TextView) findViewById(R.id.hard_title);
        hard_rank = findViewById(R.id.hard_rank);
        re_btn = findViewById(R.id.re_btn);

        SharedPreferences preferences = getSharedPreferences("logUser", 0);
        best1_n_h = preferences.getString("best1_n_h", "");
        best2_n_h = preferences.getString("best2_n_h", "");
        best3_n_h = preferences.getString("best3_n_H", "");
        best1_n_n = preferences.getString("best1_n_n", "");
        best2_n_n = preferences.getString("best2_n_n", "");
        best3_n_n = preferences.getString("best3_n_n", "");
        best1_n_e = preferences.getString("best1_n_e", "");
        best2_n_e = preferences.getString("best2_n_e", "");
        best3_n_e = preferences.getString("best3_n_e", "");
        best1_s_h = preferences.getInt("best1_s_h", 0);
        best2_s_h = preferences.getInt("best2_s_h", 0);
        best3_s_h = preferences.getInt("best3_s_h", 0);
        best1_s_n = preferences.getInt("best1_s_n", 0);
        best2_s_n = preferences.getInt("best2_s_n", 0);
        best3_s_n = preferences.getInt("best3_s_n", 0);
        best1_s_e = preferences.getInt("best1_s_e", 0);
        best2_s_e = preferences.getInt("best2_s_e", 0);
        best3_s_e = preferences.getInt("best3_s_e", 0);

        if(version_see==0){
            hard_title.setText("Hard 기록");
            hard_rank.setText("1등: " + best1_n_h + " " + best1_s_h + "\n" +
                    "2등: " + best2_n_h + " " + best2_s_h + "\n" +
                    "3등: " + best3_n_h + " " + best3_s_h);
        }
        else if(version_see==1) {
            hard_title.setText("Normal 기록");
            hard_rank.setText("1등: " + best1_n_n + " " + best1_s_n + "\n" +
                    "2등: " + best2_n_n + " " + best2_s_n + "\n" +
                    "3등: " + best3_n_n + " " + best3_s_n);
        }
        else{
            hard_title.setText("Easy 기록");
            hard_rank.setText("1등: " + best1_n_e + " " + best1_s_e + "\n" +
                    "2등: " + best2_n_e + " " + best2_s_e + "\n" +
                    "3등: " + best3_n_e + " " + best3_s_e);
        }

        re_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), activity_version_ranker.class);
                startActivity(in);
                finish();
            }
        });
    }
}
