package com.example.ansys.hahahaha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_score extends AppCompatActivity {

    TextView user, rank;
    Button re_btn;
    String name, best1_n, best2_n, best3_n;
    int correct, best1_s, best2_s, best3_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        user = (TextView) findViewById(R.id.user);
        rank = findViewById(R.id.rank);
        re_btn = findViewById(R.id.re_btn);

        SharedPreferences preferences = getSharedPreferences("logUser", 0);
        name = preferences.getString("lastUser", String.valueOf(name));
        correct = preferences.getInt("correct", correct);
        best1_n = preferences.getString("best1_n", String.valueOf(name));
        best2_n = preferences.getString("best2_n", String.valueOf(name));
        best3_n = preferences.getString("best3_n", String.valueOf(name));
        best1_s = preferences.getInt("best1_s", 0);
        best2_s = preferences.getInt("best2_s", 0);
        best3_s = preferences.getInt("best3_s", 0);

        if (correct > best3_s) {
            best3_n = name;
            best3_s = correct;
            SharedPreferences preferences1 = getSharedPreferences("logUser", 0);
            SharedPreferences.Editor editor = preferences1.edit();
            editor.putString("best3_n", String.valueOf(best3_n));
            editor.putInt("best3_s", best3_s);
            editor.apply();
        }
        if (correct > best2_s) {
            String temp_n = best2_n;
            best2_n = name;
            best3_n = temp_n;
            int temp_s = best2_s;
            best2_s = correct;
            best3_s = temp_s;
            SharedPreferences preferences2 = getSharedPreferences("logUser", 0);
            SharedPreferences.Editor editor = preferences2.edit();
            editor.putString("best3_n", String.valueOf(best3_n));
            editor.putString("best2_n", String.valueOf(best2_n));
            editor.putInt("best3_s", best3_s);
            editor.putInt("best2_s", best2_s);
            editor.apply();
        }
        if (correct > best1_s) {
            String temp_n = best1_n;
            best1_n = name;
            best2_n = temp_n;
            int temp_s = best1_s;
            best1_s = correct;
            best2_s = temp_s;
            SharedPreferences preferences3 = getSharedPreferences("logUser", 0);
            SharedPreferences.Editor editor = preferences3.edit();
            editor.putString("best2_n", String.valueOf(best2_n));
            editor.putString("best1_n", String.valueOf(best1_n));
            editor.putInt("best2_s", best2_s);
            editor.putInt("best1_s", best1_s);
            editor.apply();
        }

        user.setText("사용자 이름: " + name + " " + correct + "점");
        rank.setText("1등: " + best1_n + " " + best1_s + "\n" +
                "2등: " + best2_n + " " + best2_s + "\n" +
                "3등: " + best3_n + " " + best3_s);

        re_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });

    }
}