package com.example.ansys.hahahaha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText edit_name;
    Button start_btn, other_btn;
    String name;
    //음악버튼
    ImageButton sound_btn, sound_btn_start;
    MediaPlayer mediaPlayer;

    private BackPressCloseHandler backPressCloseHandler; //Main액티비티에서 뒤로가기 막고 토스띄움

    //액티비티가 종료될때 실행되는거
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPressCloseHandler = new BackPressCloseHandler(this); // 뒤로가기 막고 토스

        Intent intent = new Intent(this, activity_splash.class);
        startActivity(intent);

        edit_name = findViewById(R.id.edit_name);
        start_btn = findViewById(R.id.start_btn);
        other_btn = findViewById(R.id.other_btn);
        //음악
        sound_btn = findViewById(R.id.sound_btn);
        sound_btn_start=findViewById(R.id.sound_btn_start);
        sound_btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.jorgesys_song);
                mediaPlayer.start();
            }
        });

        sound_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("logUser",0);
                SharedPreferences.Editor editor = preferences.edit();
                name = edit_name.getText().toString();
                editor.putString("lastUser", String.valueOf(name));
                editor.commit();
                Intent intent = new Intent(MainActivity.this, activity_version_quiz.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        other_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기에 other클릭하면 어떤 이벤트 처리할건지 적으면 됩니다~
            }
        });
    }

    @Override  //뒤로가기 토스
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

}
