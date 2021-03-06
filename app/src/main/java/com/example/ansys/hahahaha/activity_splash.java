package com.example.ansys.hahahaha;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class activity_splash extends AppCompatActivity {

    public static int a = 0; //스플래쉬 한번 실행되도록 하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView quiz_image = (ImageView)findViewById(R.id.quiz_image);
        ImageView quiz_word = (ImageView)findViewById(R.id.quiz_word);

        Animation animation_image = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.image_splash);
        Animation animation_word = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.word_splash);
        quiz_image.startAnimation(animation_image);
        quiz_word.startAnimation(animation_word);

        if (a==0) {
            startLoading();
            this.a = 1;
        }
        else
            finish();

    }

    private void startLoading(){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        //스플래시 화면에서 뒤로가기 기능 제거
    }

}
