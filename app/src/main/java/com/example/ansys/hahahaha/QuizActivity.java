package com.example.ansys.hahahaha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private Intent intent;
    private String mode;
    private ArrayList<QuestionBean> quizData;
    private LinearLayout quizImageLayout, quizTextLayout;
    private TextView questionText, quizText1, quizText2, quizText3, quizText4;
    private RadioGroup radioGroup;
    private int index = 0;
    private TextView count;
    private Button quit_btn;
    int score=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myquiz);
        quizTextLayout = findViewById(R.id.QuizTextLayout);
        questionText = findViewById(R.id.questionText);
        radioGroup = findViewById(R.id.quizradioGroup);
        quizText1 = findViewById(R.id.QuizText1);
        quizText2 = findViewById(R.id.QuizText2);
        quizText3 = findViewById(R.id.QuizText3);
        quizText4 = findViewById(R.id.QuizText4);
        quit_btn=findViewById(R.id.quit_btn);
        count = findViewById(R.id.count);
        intent = getIntent();

        setQuizData();
        setLayout();

        quit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, activity_other.class);
                startActivity(intent);
            }
        });
    }

    private void setQuizData(){
        quizData = activity_other.questionDBHelper.select();
    }

    private void setLayout() {
        if (quizData.size() == 0) {
            Toast.makeText(QuizActivity.this, "문제가 없습니다.", Toast.LENGTH_SHORT).show();
            finish();
        } else if (quizData.size() == index) {
            Toast.makeText(QuizActivity.this, "문제가 끝났습니다. 총점 : "+score, Toast.LENGTH_SHORT).show();
            finish();
        } else {
            count.setText(index+1+"/"+quizData.size());
            radioGroup.clearCheck();
            setData();
        }
    }

    private void setData(){
        questionText.setText(quizData.get(index).getQuestion());
        quizText1.setText(quizData.get(index).getChoices()[0]);
        quizText2.setText(quizData.get(index).getChoices()[1]);
        quizText3.setText(quizData.get(index).getChoices()[2]);
        quizText4.setText(quizData.get(index).getChoices()[3]);

    }

    public void checkAnswer(View v){
        int select = 0;
        select = radioGroup.getCheckedRadioButtonId();
        int answer = quizData.get(index).getAnswer();
        if(answer == 1 && select == R.id.quizButton1){
            Toast.makeText(QuizActivity.this, "정답! ", Toast.LENGTH_SHORT).show();
            score++;
        }
        else if(answer == 2 && select == R.id.quizButton2){
            Toast.makeText(QuizActivity.this, "정답! ", Toast.LENGTH_SHORT).show();
            score++;
        }
        else if(answer == 3 && select == R.id.quizButton3){
            Toast.makeText(QuizActivity.this, "정답! ", Toast.LENGTH_SHORT).show();
            score++;
        }
        else if(answer == 4 && select == R.id.quizButton4){
            Toast.makeText(QuizActivity.this, "정답! ", Toast.LENGTH_SHORT).show();
            score++;
        }
        else if(radioGroup.getCheckedRadioButtonId()==-1){
            Toast.makeText(QuizActivity.this, "정답을 선택해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Toast.makeText(QuizActivity.this, "오답", Toast.LENGTH_SHORT).show();
        }

        index++;
        setLayout();
    }
}
