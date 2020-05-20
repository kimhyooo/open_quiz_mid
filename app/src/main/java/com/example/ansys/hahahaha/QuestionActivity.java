package com.example.ansys.hahahaha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    private EditText question;
    private android.widget.EditText score;
    private EditText text1;
    private EditText text2;
    private EditText text3;
    private EditText text4;
    private LinearLayout TextLayout;
    private RadioGroup radioGroup;
    private int answer;
    private int type;
    private final int REQ_CODE_SELECT_IMAGE = 100;
    private Intent intent;

    private String choice1 = "";
    private String choice2 = "";
    private String choice3 = "";
    private String choice4 = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = findViewById(R.id.editTextQuestion);
        text1 = findViewById(R.id.Questext1);
        text2 = findViewById(R.id.Questext2);
        text3 = findViewById(R.id.Questext3);
        text4 = findViewById(R.id.Questext4);
        this.TextLayout = findViewById(R.id.TextLayout);
        radioGroup = findViewById(R.id.radioGroup2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1)
                    answer = 1;
                else if (checkedId == R.id.radioButton2)
                    answer = 2;
                else if (checkedId == R.id.radioButton3)
                    answer = 3;
                else if (checkedId == R.id.radioButton4)
                    answer = 4;
            }
        });
        answer = 0;

        type = QuestionBean.TYPE_TEXT;
        intent = getIntent();
        choice1 = "";
        choice2 = "";
        choice3 = "";
        choice4 = "";

        if (intent.getStringExtra("type").equals("modify")) {
            setQuestionData();
        }
    }


    private void setQuestionData() {
        int id = intent.getIntExtra("index", 0);
        QuestionBean data = activity_other.questionDBHelper.select(id + 1);
        question.setText(data.getQuestion());
        if (data.getType() == QuestionBean.TYPE_TEXT) {
            text1.setText(data.getChoices()[0]);
            text2.setText(data.getChoices()[1]);
            text3.setText(data.getChoices()[2]);
            text4.setText(data.getChoices()[3]);
        }

        switch (data.getAnswer()) {
            case 1:
                radioGroup.check(R.id.radioButton1);
                break;
            case 2:
                radioGroup.check(R.id.radioButton2);
                break;
            case 3:
                radioGroup.check(R.id.radioButton3);
                break;
            case 4:
                radioGroup.check(R.id.radioButton4);
                break;
        }
        choice1 = data.getChoices()[0];
        choice2 = data.getChoices()[1];
        choice3 = data.getChoices()[2];
        choice4 = data.getChoices()[3];
    }

    public void deleteQuestion(View v) {
        if (intent.getStringExtra("type").equals("new"))
            finish();
        int id = intent.getIntExtra("index", 0);
        activity_other.questionDBHelper.delete(id + 1);
        Toast.makeText(QuestionActivity.this, "문제를 삭제했습니다.", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void setQuestion(View v) {
        String title = question.getText().toString();
        if (type == QuestionBean.TYPE_TEXT) {
            choice1 = text1.getText().toString();
            choice2 = text2.getText().toString();
            choice3 = text3.getText().toString();
            choice4 = text4.getText().toString();
        }

        if (title.equals("") ||choice1.equals("") || choice2.equals("") || choice3.equals("") || choice4.equals("")) {
            Toast.makeText(QuestionActivity.this, "공백이 존재합니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (answer == 0) {
            Toast.makeText(QuestionActivity.this, "정답을 선택해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] choices = {choice1, choice2, choice3, choice4};
        QuestionBean questionBean = new QuestionBean();
        questionBean.setType(type);
        questionBean.setChoices(choices);
        questionBean.setQuestion(title);
        questionBean.setAnswer(answer);
        if (intent.getStringExtra("type").equals("new")) {
            activity_other.questionDBHelper.insert(questionBean);
            Toast.makeText(QuestionActivity.this, "문제가 저장되었습니다.", Toast.LENGTH_SHORT).show();
        } else if (intent.getStringExtra("type").equals("modify")) {
            questionBean.setId(intent.getIntExtra("index", 0) + 1);
            activity_other.questionDBHelper.update(questionBean);
            Toast.makeText(QuestionActivity.this, "문제가 수정되었습니다.", Toast.LENGTH_SHORT).show();
        }
        //이전 화면으로 이동
        finish();
    }
}