package com.songdehuai.myimui.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.songdehuai.myimui.ChatActivity;
import com.songdehuai.myimui.R;
import com.songdehuai.myimui.adapter.MsgListAdapter;
import com.songdehuai.myimui.bean.MsgListBean;

/**
 * Created by Doracoin on 2017/7/17.
 */
public class MsgListPager extends BasePager {
    private ListView msgLv;
    private MsgListAdapter msgAdp;

    private Handler handler = new Handler();

    public MsgListPager(Context context) {
        super(context);
    }

    @Override
    public void initView() {
        setContentView(R.layout.pager_msglist);
        msgLv = (ListView) findViewById(R.id.pager_msg_list);
        msgAdp = new MsgListAdapter(context);
        msgLv.setAdapter(msgAdp);
        msgLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(context, ChatActivity.class));
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    MsgListBean bean = new MsgListBean();
                    bean.setObj_avatar_path("");
                    bean.setObj_date(System.currentTimeMillis() + (1000 * 60 * i));
                    Log.e("time","time:   "+bean.getObj_date());
                    bean.setObj_id(65535 * i);
                    bean.setObj_recent_message("为什么iOS就可以实现？");
                    bean.setObj_name("测试员工" + i);
                    msgAdp.getInnerList().add(bean);
                }
                msgAdp.refresh();
            }
        }, 200);
    }
}
