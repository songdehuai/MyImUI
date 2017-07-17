package com.songdehuai.immsglist;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.songdehuai.immsglist.adapter.ImMsgLilstAdapter;
import com.songdehuai.immsglist.adapter.MsgAdapter;
import com.songdehuai.immsglist.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class ImMsgListView extends LinearLayout {


    View rootView;
    SwipeRefreshLayout refreshLayout;
    RecyclerView im_msg_rv;

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
        im_msg_rv = (RecyclerView) rootView.findViewById(R.id.im_msg_rv);
        im_msg_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });
        intMsgList();
    }

    List<Msg> msgList = new ArrayList<>();
    ImMsgLilstAdapter msgAdapter;

    void intMsgList() {
        msgAdapter = new ImMsgLilstAdapter(getContext(), msgList);
        im_msg_rv.setAdapter(msgAdapter);
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
        msgTmp.setFriendImg("");
        msgTmp.setUserImg("");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        smoothScrollToPosition();
    }

    public void SendImg(Uri img) {
        Msg msgTmp = new Msg();
        msgTmp.setType("send_img");
        msgTmp.setUri(img);
        msgTmp.setFriendImg("");
        msgTmp.setUserImg("");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        smoothScrollToPosition();
    }

    /**
     * 发送语音
     *
     * @param voice
     */
    public void SendVoice(String voice) {
        Msg msgTmp = new Msg();
        msgTmp.setType("send_voice");
        msgTmp.setFriendImg("");
        msgTmp.setUserImg("");
        msgTmp.setVoiceLen(voice);
        msgTmp.setVoiceUri("test");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        smoothScrollToPosition();
    }


    public void ReceiveImg(Uri img) {
        Msg msgTmp = new Msg();
        msgTmp.setUri(img);
        msgTmp.setType("receive_img");
        msgTmp.setFriendImg("");
        msgTmp.setUserImg("");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        smoothScrollToPosition();
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
        msgTmp.setFriendImg("");
        msgTmp.setUserImg("");
        msgList.add(msgTmp);
        if (msgAdapter != null) {
            msgAdapter.notifyDataSetChanged();
        }
        smoothScrollToPosition();
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

    void smoothScrollToPosition() {
        im_msg_rv.post(new Runnable() {
            @Override
            public void run() {
                im_msg_rv.smoothScrollToPosition(im_msg_rv.getBottom());
            }
        });
    }

}
