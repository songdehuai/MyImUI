package com.songdehuai.iminput;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * 描述：即时通讯聊天输入组件
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.myimui.iminput. ImInput
 * @date 2017/7/14 14:13
 */
public class ImInput extends LinearLayout {

    EditText edit;
    ImageView image, send, voice;
    View rootView;

    private ImInputListener imInputListener;

    public void setImInputListener(ImInputListener imInputListener) {
        this.imInputListener = imInputListener;
    }


    public ImInput(Context context) {
        super(context);
        initLayout(context);
    }

    public ImInput(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public ImInput(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }


    void initLayout(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.iminput_layout, this);
        edit = (EditText) rootView.findViewById(R.id.iminput_edit);
        image = (ImageView) rootView.findViewById(R.id.iminput_img);
        send = (ImageView) rootView.findViewById(R.id.iminput_send);
        voice = (ImageView) rootView.findViewById(R.id.iminput_voice);
        setOnCLick();
    }

    private void setOnCLick() {
        send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit != null && !TextUtils.isEmpty(edit.getText())) {
                    imInputListener.onSendClick(edit.getText().toString());
                    edit.setText("");
                }
            }
        });
        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imInputListener.onImageClick();
            }
        });

        voice.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imInputListener.onVoiceClick();
            }
        });
    }


    public interface ImInputListener {

        void onSendClick(String text);

        void onImageClick();

        void onVoiceClick();

    }
}
