package com.songdehuai.myimui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.songdehuai.myimui.ChatActivity;
import com.songdehuai.myimui.R;
import com.songdehuai.myimui.adapter.MsgListAdapter;
import com.songdehuai.myimui.bean.MsgListBean;

import org.xutils.x;

/**
 * Created by hp on 2017/7/19.
 */

public class ChatListFragment extends Fragment {
    private ListView msgLv;
    private MsgListAdapter msgAdp;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.pager_msglist, null);
        x.view().inject(this, v);

        msgLv = (ListView) v.findViewById(R.id.pager_msg_list);
        msgAdp = new MsgListAdapter(getContext());
        msgLv.setAdapter(msgAdp);
        msgLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    MsgListBean bean = new MsgListBean();
                    bean.setObj_avatar_path("");
                    bean.setObj_date(System.currentTimeMillis() + (1000 * 60 * 5 * i));
                    Log.e("time", "time:   " + bean.getObj_date());
                    bean.setObj_id(65535 * i);
                    bean.setObj_recent_message("为什么iOS就可以实现？");
                    bean.setObj_name("测试员工" + i);
                    msgAdp.getInnerList().add(bean);
                }
                msgAdp.refresh();
            }
        }, 200);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
