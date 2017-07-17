package com.songdehuai.immsglist;


import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ImMsgListView extends View {
    public ImMsgListView(Context context) {
        super(context);
    }

    public ImMsgListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImMsgListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
    }
}
