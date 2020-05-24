package com.example.ansys.hahahaha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.ansys.hahahaha.activity_version_quiz.version_see;

public class activity_score extends AppCompatActivity {

    TextView user, rank;
    Button re_btn;
    String name, best1_n_h, best2_n_h, best3_n_h, best1_n_n, best2_n_n, best3_n_n, best1_n_e, best2_n_e, best3_n_e;
    int correct, best1_s_h, best2_s_h, best3_s_h, best1_s_n, best2_s_n, best3_s_n, best1_s_e, best2_s_e, best3_s_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        user = (TextView) findViewById(R.id.user);
        rank = findViewById(R.id.rank);
        re_btn = findViewById(R.id.re_btn);

        SharedPreferences preferences = getSharedPreferences("logUser", 0);
        name = preferences.getString("lastUser", String.valueOf(name));
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
            correct = preferences.getInt("hard_correct", correct);
            if (correct > best3_s_h) {
                best3_n_h = name;
                best3_s_h = correct;
                SharedPreferences preferences1 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences1.edit();
                editor.putString("best3_n_h", String.valueOf(best3_n_h));
                editor.putInt("best3_s_h", best3_s_h);
                editor.apply();
            }
            if (correct > best2_s_h) {
                String temp_n = best2_n_h;
                best2_n_h = name;
                best3_n_h = temp_n;
                int temp_s = best2_s_h;
                best2_s_h = correct;
                best3_s_h = temp_s;
                SharedPreferences preferences2 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences2.edit();
                editor.putString("best3_n_h", String.valueOf(best3_n_h));
                editor.putString("best2_n_h", String.valueOf(best2_n_h));
                editor.putInt("best3_s_h", best3_s_h);
                editor.putInt("best2_s_h", best2_s_h);
                editor.apply();
            }
            if (correct > best1_s_h) {
                String temp_n = best1_n_h;
                best1_n_h = name;
                best2_n_h = temp_n;
                int temp_s = best1_s_h;
                best1_s_h = correct;
                best2_s_h = temp_s;
                SharedPreferences preferences3 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putString("best2_n_h", String.valueOf(best2_n_h));
                editor.putString("best1_n_h", String.valueOf(best1_n_h));
                editor.putInt("best2_s_h", best2_s_h);
                editor.putInt("best1_s_h", best1_s_h);
                editor.apply();
            }
            user.setText("사용자 이름: " + name + " " + correct + "점");
            rank.setText("1등: " + best1_n_h + " " + best1_s_h + "\n" +
                    "2등: " + best2_n_h + " " + best2_s_h + "\n" +
                    "3등: " + best3_n_h + " " + best3_s_h);
        }
        if(version_see==1){
            correct = preferences.getInt("normal_correct", correct);
            if (correct > best3_s_n) {
                best3_n_n = name;
                best3_s_n = correct;
                SharedPreferences preferences1 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences1.edit();
                editor.putString("best3_n_n", String.valueOf(best3_n_n));
                editor.putInt("best3_s_n_n", best3_s_n);
                editor.apply();
            }
            if (correct > best2_s_n) {
                String temp_n = best2_n_n;
                best2_n_n = name;
                best3_n_n = temp_n;
                int temp_s = best2_s_n;
                best2_s_n = correct;
                best3_s_n = temp_s;
                SharedPreferences preferences2 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences2.edit();
                editor.putString("best3_n_n", String.valueOf(best3_n_n));
                editor.putString("best2_n_n", String.valueOf(best2_n_n));
                editor.putInt("best3_s_n", best3_s_n);
                editor.putInt("best2_s_n", best2_s_n);
                editor.apply();
            }
            if (correct > best1_s_n) {
                String temp_n = best1_n_n;
                best1_n_n = name;
                best2_n_n = temp_n;
                int temp_s = best1_s_n;
                best1_s_n = correct;
                best2_s_n = temp_s;
                SharedPreferences preferences3 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putString("best2_n_n", String.valueOf(best2_n_n));
                editor.putString("best1_n_n", String.valueOf(best1_n_n));
                editor.putInt("best2_s_n", best2_s_n);
                editor.putInt("best1_s_n", best1_s_n);
                editor.apply();
            }
            user.setText("사용자 이름: " + name + " " + correct + "점");
            rank.setText("1등: " + best1_n_n + " " + best1_s_n + "\n" +
                    "2등: " + best2_n_n + " " + best2_s_n + "\n" +
                    "3등: " + best3_n_n + " " + best3_s_n);
        }
        if(version_see==2){
            correct = preferences.getInt("easy_correct", correct);
            if (correct > best3_s_e) {
                best3_n_e = name;
                best3_s_e = correct;
                SharedPreferences preferences1 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences1.edit();
                editor.putString("best3_n_e", String.valueOf(best3_n_e));
                editor.putInt("best3_s_e", best3_s_e);
                editor.apply();
            }
            if (correct > best2_s_e) {
                String temp_n = best2_n_e;
                best2_n_e = name;
                best3_n_e = temp_n;
                int temp_s = best2_s_e;
                best2_s_e = correct;
                best3_s_e = temp_s;
                SharedPreferences preferences2 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences2.edit();
                editor.putString("best3_n_e", String.valueOf(best3_n_e));
                editor.putString("best2_n_e", String.valueOf(best2_n_e));
                editor.putInt("best3_s_e", best3_s_e);
                editor.putInt("best2_s_e", best2_s_e);
                editor.apply();
            }
            if (correct > best1_s_e) {
                String temp_n = best1_n_e;
                best1_n_e = name;
                best2_n_e = temp_n;
                int temp_s = best1_s_e;
                best1_s_e = correct;
                best2_s_e = temp_s;
                SharedPreferences preferences3 = getSharedPreferences("logUser", 0);
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putString("best2_n_e", String.valueOf(best2_n_e));
                editor.putString("best1_n_e", String.valueOf(best1_n_e));
                editor.putInt("best2_s_e", best2_s_e);
                editor.putInt("best1_s_e", best1_s_e);
                editor.apply();
            }
            user.setText("사용자 이름: " + name + " " + correct + "점");
            rank.setText("1등: " + best1_n_e + " " + best1_s_e + "\n" +
                    "2등: " + best2_n_e + " " + best2_s_e + "\n" +
                    "3등: " + best3_n_e + " " + best3_s_e);
        }

        re_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}