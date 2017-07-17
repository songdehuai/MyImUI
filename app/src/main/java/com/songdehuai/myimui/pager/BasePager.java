package com.songdehuai.myimui.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

/**
 * @author Doracoin
 */
public abstract class BasePager implements View.OnClickListener, View.OnFocusChangeListener {

    public final Context context;
    public View rootView;
    public boolean isInit = false;

    private Toast mToast = null;

    public Handler handler = new Handler();

    public BasePager(Context context) {
        this.context = context;
        initView();
    }

    public void startActivity(Intent intent) {
        context.startActivity(intent);
    }

    public void jump2(Class<?> cls) {
        startActivity(new Intent(context, cls));
    }

    public void setContentView(int id) {
        setContentView(View.inflate(context, id, null));
    }

    public void setContentView(View contentView) {
        rootView = contentView;
        rootView.setOnFocusChangeListener(this);
    }

    public View findViewById(int id) {
        return rootView.findViewById(id);
    }

    public abstract void initView();

    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }

    public void onRefresh() {

    }

    public void runOnUiThread(Runnable run) {
        handler.post(run);
    }

    public void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public void toastAppend(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text);
        mToast.show();
    }
}
