package com.songdehuai.myimui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.songdehuai.iminput.ImInput;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    ImInput imInput;

    void initViews() {
        imInput = (ImInput) findViewById(R.id.iminput);
        imInput.setImInputListener(new ImInput.ImInputListener() {
            @Override
            public void onSendClick(String text) {

            }

            @Override
            public void onImageClick() {

            }

            @Override
            public void onVoiceClick() {

            }
        });
    }
}
