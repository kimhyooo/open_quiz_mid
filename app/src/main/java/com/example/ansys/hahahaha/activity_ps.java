package com.example.ansys.hahahaha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_ps extends AppCompatActivity {

    private String pw = "1234";
    private Button enterbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ps);
    }
    public void onConfirm(View v) {
        EditText password = findViewById(R.id.pwText);
        enterbutton = findViewById(R.id.enterbtn);
        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pw.equals(password.getText().toString())) {
                    Intent intent = new Intent(activity_ps.this, activity_other.class);
                    startActivity(intent);
                } else
                    finish();
            }
        });
    }
}
