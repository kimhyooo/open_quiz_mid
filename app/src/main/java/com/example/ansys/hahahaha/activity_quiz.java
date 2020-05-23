package com.example.ansys.hahahaha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class activity_quiz extends AppCompatActivity {

    private TextView receive_name, quiz_title;
    RadioButton rb1,rb2,rb3,rb4;
    Button next_btn, quit_btn;
    RadioGroup rb_grp;
    ImageButton hint_btn;    //힌트버튼
    TextView count_quiz;
    int count = 1;

    int hint_see = activity_version_quiz.hint_see; //version_quiz에 있는 hint_see 변수 값 들고 옴
    int version_see = activity_version_quiz.version_see;

    ///타이머
    TextView timer_text;
    private static final long START_TIME_IN_MILLIS = 60000;  //hard버전
    private static final long START_TIME_IN_MILLIS_1 = 90000;  //normal버전
    private static final long START_TIME_IN_MILLIS_2 = 180000;  //easy버전

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;  //hard
    private long mTimeLeftInMillis_1 = START_TIME_IN_MILLIS_1;  //normal
    private long mTimeLeftInMillis_2 = START_TIME_IN_MILLIS_2;  //easy

    int quit_btn_re = 0; //종료버튼 눌렀을때 화면 다시 안뜨게하는거


    //문제
    String question[] = {
            "프로그램에서 한 번만 정의 할 수있는 것은 무엇일까요?",
            "비트 연산자가 아닌 것은 무엇일까요?",
            "메소드에서 키워드를 호출 한 오브젝트를 참조하기 위해 사용하는 키워드는 무엇일까요?",
            "Java에서 인터페이스를 정의하는 데 사용되는 키워드는 무엇일까요?",
            "인터페이스에 사용할 수있는 액세스 지정자는 무엇일까요?",
            "다음 중 전체 패키지 'pkg'를 가져 오는 올바른 방법은 무엇일까요?",
            "생성자의 반환 유형은 무엇일까요?",
            "다음 중 표준 Java 클래스를 모두 저장하는 패키지는 무엇일까요?",
            "두 String 객체가 동일한지 비교하기 위해 String 클래스의 다음 중 어떤 방법을 사용할까요?",
            "바이트, 정수 및 리터럴 숫자를 포함하는 표현식이 다음 중 어느 것으로 오를까요?"
    };

    //정답 리스트
    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    //오답 리스트
    String opt[] = {
            "finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };


    int flag = 0; //문제1번부터 연결
    public static int marks=0, correct=0, wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        receive_name = findViewById(R.id.receive_name);
        hint_btn = findViewById(R.id.hint_btn); //힌트버튼 연결

        final TextView score = findViewById(R.id.score);

        //수 증가
        count_quiz = findViewById(R.id.count_quiz);

        //이름불러오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        receive_name.setText(name);


        next_btn = findViewById(R.id.next_btn); //다음버튼연결
        quit_btn = findViewById(R.id.quit_btn); //종료버튼연결
        quiz_title = findViewById(R.id.quiz_title); //퀴즈문제 나오는 텍스트연결
        rb_grp = findViewById(R.id.rb_grp); //라디오그룹연결

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        quiz_title.setText(question[flag]);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);


        if(hint_see==1) {
            hint_btn.setVisibility(View.VISIBLE);
        }
        else{
            hint_btn.setVisibility(View.INVISIBLE);
        }

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;

                   RadioButton uans = findViewById(rb_grp.getCheckedRadioButtonId());
                   String ansText = uans.getText().toString(); //사용자가 한 텍스트


                //맞았다면 정답 토스
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "정답!", Toast.LENGTH_SHORT).show();

                }
                //틀리면 틀렸다는 토스
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "오답!", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<question.length)
                {
                    quiz_title.setText(question[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);

                    if (rb_grp.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getApplicationContext(), "하나를 고르세요!", Toast.LENGTH_SHORT).show();
                        count--;
                        count_quiz.setText(count + "/" + question.length);
                        return;}
                    else {
                        count_quiz.setText(count + "/" + question.length);
                    }
                }
                else
                {
                    count--;
                    count_quiz.setText(count + "/" + question.length);
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),activity_result.class);
                    startActivity(in);
                }
                rb_grp.clearCheck();
            }
        });

        quit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimerRunning = false;
                quit_btn_re=1; // 이 버튼 누르면 1로 바뀜
                resetTimer();

                if(version_see==0){
                    SharedPreferences preferences = getSharedPreferences("logUser",0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("hard_correct",correct);
                    editor.commit();
                    Intent intent=new Intent(getApplicationContext(),activity_result.class);
                    startActivity(intent);
                }
                if(version_see==1){
                    SharedPreferences preferences = getSharedPreferences("logUser",0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("normal_correct",correct);
                    editor.commit();
                    Intent intent=new Intent(getApplicationContext(),activity_result.class);
                    startActivity(intent);
                }
                if(version_see==2){
                    SharedPreferences preferences = getSharedPreferences("logUser",0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("easy_correct",correct);
                    editor.commit();
                    Intent intent=new Intent(getApplicationContext(),activity_result.class);
                    startActivity(intent);
                }
            }
        });


        //타이머
        timer_text = findViewById(R.id.timer_text); //텍스트
        if (mTimerRunning) pauseTimer();
        else startTimer();

        updateCountDownText();
    }

    private void startTimer() {
        if(version_see==0){
            mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }
                @Override
                public void onFinish() {
                    if(quit_btn_re==1){
                        mTimerRunning = false;
                        finish();
                    }
                    else if(count + 1==11){
                        mTimerRunning = false;
                        resetTimer();
                        finish();
                    }
                    else {
                        mTimerRunning = false;
                        SharedPreferences preferences = getSharedPreferences("logUser",0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("hard_correct",correct);
                        editor.commit();
                        Intent in = new Intent(activity_quiz.this, activity_result  .class);
                        startActivity(in);
                        finish();
                    }

                }
            }.start();
            mTimerRunning = true;

        }

        if(version_see==1){
            mCountDownTimer = new CountDownTimer(mTimeLeftInMillis_1, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis_1 = millisUntilFinished;
                    updateCountDownText();
                }
                @Override
                public void onFinish() {
                    if(quit_btn_re==1){
                        mTimerRunning = false;
                        finish();
                    }
                    else if(count + 1 ==11){
                        mTimerRunning = false;
                        resetTimer();
                        finish();
                    }
                    else {
                        mTimerRunning = false;
                        SharedPreferences preferences = getSharedPreferences("logUser",0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("normal_correct",correct);
                        editor.commit();
                        Intent in = new Intent(activity_quiz.this, activity_result  .class);
                        startActivity(in);
                        finish();
                    }

                }
            }.start();
            mTimerRunning = true;
        }

        if(version_see==2){
            mCountDownTimer = new CountDownTimer(mTimeLeftInMillis_2, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis_2 = millisUntilFinished;
                    updateCountDownText();
                }
                @Override
                public void onFinish() {
                    if(quit_btn_re==1){
                        mTimerRunning = false;
                        finish();
                    }
                    else if(count + 1 ==11){
                        mTimerRunning = false;
                        resetTimer();
                        finish();
                    }
                    else {
                        mTimerRunning = false;
                        SharedPreferences preferences = getSharedPreferences("logUser",0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("easy_correct",correct);
                        editor.commit();
                        Intent in = new Intent(activity_quiz.this, activity_result  .class);
                        startActivity(in);
                        finish();
                    }

                }
            }.start();
            mTimerRunning = true;
        }
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mTimerRunning = false;
    }


    private void updateCountDownText() {
        if(version_see==0){
            int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
            int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
            timer_text.setText(timeLeftFormatted);
        }
        if(version_see==1){
            int minutes = (int) (mTimeLeftInMillis_1 / 1000) / 60;
            int seconds = (int) (mTimeLeftInMillis_1 / 1000) % 60;
            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
            timer_text.setText(timeLeftFormatted);
        }
        if(version_see==2){
            int minutes = (int) (mTimeLeftInMillis_2 / 1000) / 60;
            int seconds = (int) (mTimeLeftInMillis_2 / 1000) % 60;
            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
            timer_text.setText(timeLeftFormatted);
        }

    }

    private void resetTimer() {
        if(version_see==0){
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
            updateCountDownText();
        }
        else if(version_see==1){
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
            updateCountDownText();
        }
        else if(version_see==2){
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
            updateCountDownText();
        }
    }

    //힌트
    public void hint(View view){
        AlertDialog.Builder dlg = new AlertDialog.Builder(activity_quiz.this);
        if(flag==0){
            dlg.setTitle("1번문제 힌트");
            dlg.setMessage("main method");
            dlg.show();
        }
        if(flag==1){
            dlg.setTitle("2번문제 힌트");
            dlg.setMessage("<=");
            dlg.show();
        }
        if(flag==2){
            dlg.setTitle("3번문제 힌트");
            dlg.setMessage("this");
            dlg.show();
        }
        if(flag==3){
            dlg.setTitle("4번문제 힌트");
            dlg.setMessage("interface");
            dlg.show();
        }
        if(flag==4){
            dlg.setTitle("5번문제 힌트");
            dlg.setMessage("public");
            dlg.show();
        }
        if(flag==5){
            dlg.setTitle("6번문제 힌트");
            dlg.setMessage("import pkg.*");
            dlg.show();
        }
        if(flag==6){
            dlg.setTitle("7번문제 힌트");
            dlg.setMessage("None of the mentioned");
            dlg.show();
        }
        if(flag==7){
            dlg.setTitle("8번문제 힌트");
            dlg.setMessage("java");
            dlg.show();
        }
        if(flag==8){
            dlg.setTitle("9번문제 힌트");
            dlg.setMessage("equals()");
            dlg.show();
        }
        if(flag==9){
            dlg.setTitle("10번문제 힌트");
            dlg.setMessage("int");
            dlg.show();
        }
    }

    @Override
    public void onBackPressed() {
        //뒤로가기 막음
    }
}
