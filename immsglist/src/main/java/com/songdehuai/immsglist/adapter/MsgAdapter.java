package com.songdehuai.immsglist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.songdehuai.immsglist.R;
import com.songdehuai.immsglist.entity.Msg;

import java.util.List;

/**
 * 描述：消息列表适配器
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.immsglist.adapter. MsgAdapter
 * @date 2017/7/14 16:06
 */

public class MsgAdapter extends BaseAdapter {

    Context context;
    List<Msg> listMsg;

    public MsgAdapter(Context context, List<Msg> listMsg) {
        this.context = context;
        this.listMsg = listMsg;
    }

    @Override
    public int getCount() {
        return listMsg.size();
    }

    @Override
    public Object getItem(int position) {
        return listMsg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    MsgReceiveViewHolder receiveViewHolder;
    MsgSendViewHolder sendViewHolder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (listMsg.get(position).getType().equals("receive")) {
            convertView = View.inflate(context, R.layout.item_msg_receive, null);
        } else if (listMsg.get(position).getType().equals("send")) {
            convertView = View.inflate(context, R.layout.item_msg_receive, null);
        }

        return convertView;
    }


    public static class MsgSendViewHolder {

        public MsgSendViewHolder(View itemView) {

        }
    }


    public static class MsgReceiveViewHolder {

        public MsgReceiveViewHolder(View itemView) {

        }
    }

}
