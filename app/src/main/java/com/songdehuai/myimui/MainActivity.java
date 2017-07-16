package com.songdehuai.myimui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.songdehuai.iminput.ImInput;
import com.songdehuai.immsglist.ImMsgListView;
import com.songdehuai.immsglist.entity.Msg;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    ImInput imInput;
    ImMsgListView imList;

    List<Msg> msgList;

    void initViews() {
        msgList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Msg msgTemp = new Msg();
            msgTemp.setText("测试测试" + i);
            msgTemp.setType("send_text");
            msgList.add(msgTemp);
        }
        imInput = (ImInput) findViewById(R.id.iminput);
        imList = (ImMsgListView) findViewById(R.id.imlist);

        imList.setMsgList(msgList);
        imInput.setImInputListener(new ImInput.ImInputListener() {
            @Override
            public void onSendClick(String text) {
                imList.SendMsg(text);
                imList.Receive(text);
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
