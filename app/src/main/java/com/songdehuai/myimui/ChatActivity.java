package com.songdehuai.myimui;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.songdehuai.iminput.ImInput;
import com.songdehuai.immsglist.ImMsgListView;
import com.songdehuai.immsglist.entity.Msg;
import com.songdehuai.myimui.utils.SoftInputUtil;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private SoftInputUtil softUtil = new SoftInputUtil();

    static final int code = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
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
            }

            @Override
            public void onImageClick() {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, code);
            }

            @Override
            public void onVoiceClick() {
                imList.SendVoice("20");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == code) {
            if (data != null) {
                Uri uri = data.getData();
                if (uri != null) {
                    imList.SendImg(uri);
                }
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        softUtil.checkKeyboard(this,ev);
        return super.dispatchTouchEvent(ev);
    }
}
