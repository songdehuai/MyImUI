package com.songdehuai.immsglist;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.songdehuai.immsglist.adapter.MsgAdapter;
import com.songdehuai.immsglist.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class ImMsgListView extends LinearLayout {


    View rootView;
    SwipeRefreshLayout refreshLayout;
    ListView imLv;

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
        initViews();
    }

    void initViews() {
        refreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.im_msg_rfl);
        imLv = (ListView) rootView.findViewById(R.id.im_msg_lv);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });
        intMsgList();
    }

    MsgAdapter msgAdapter;
    List<Msg> msgList = new ArrayList<>();

    void intMsgList() {
        msgAdapter = new MsgAdapter(getContext(), msgList);
        imLv.setAdapter(msgAdapter);
    }

    /**
     * 发送消息
     *
     * @param msg
     */
    public void SendMsg(String msg) {
        Msg msgTmp = new Msg();
        msgTmp.setText(msg);
        msgTmp.setType("send_text");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        imLv.post(new Runnable() {
            @Override
            public void run() {
                imLv.smoothScrollToPosition(imLv.getBottom());
            }
        });
    }

    /**
     * 接收消息
     *
     * @param msg
     */
    public void Receive(String msg) {
        Msg msgTmp = new Msg();
        msgTmp.setText(msg);
        msgTmp.setType("receive_text");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        imLv.post(new Runnable() {
            @Override
            public void run() {
                imLv.smoothScrollToPosition(imLv.getBottom());
            }
        });
    }

    /**
     * 设置数据
     *
     * @param msgList
     */
    public void setMsgList(List<Msg> msgList) {
        this.msgList = msgList;
        if (msgList != null) {
            msgAdapter.setListMsg(msgList);
            msgAdapter.notifyDataSetChanged();
        }
    }
}
