package com.songdehuai.iminput;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    ImageButton image, send, voice;
    Button void_btn;
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

    InputMethodManager imm;

    void initLayout(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.iminput_layout, this);
        edit = (EditText) rootView.findViewById(R.id.iminput_edit);
        image = (ImageButton) rootView.findViewById(R.id.iminput_img);
        send = (ImageButton) rootView.findViewById(R.id.iminput_send);
        voice = (ImageButton) rootView.findViewById(R.id.iminput_voice);
        void_btn = (Button) rootView.findViewById(R.id.iminput_voice_btn);
        setOnCLick();
        imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
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
        voice.setTag("0");
        voice.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voice.getTag().equals("0")) {
                    void_btn.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);
                    voice.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard));
                    voice.setTag("1");
                    if (imm.isActive()) {
                        // 关闭键盘
                        imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
                    }
                } else {
                    void_btn.setVisibility(View.GONE);
                    edit.setVisibility(View.VISIBLE);
                    voice.setImageDrawable(getResources().getDrawable(R.drawable.ic_voice));
                    voice.setTag("0");
                }
            }
        });
        void_btn.setOnClickListener(new OnClickListener() {
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
