package com.songdehuai.immsglist;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.songdehuai.immsglist.adapter.MsgAdapter;

public class ImMsgListView extends LinearLayout {


    View rootView;

    SwipeRefreshLayout refreshLayout;

    RecyclerView recyclerView;

    public ImMsgListView(Context context) {
        super(context);
        initLayout(context);
    }

    public ImMsgListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public ImMsgListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    void initLayout(Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.msg_list, this);
    }


    MsgAdapter msgAdapter;

    void intMsgList() {

    }

}
