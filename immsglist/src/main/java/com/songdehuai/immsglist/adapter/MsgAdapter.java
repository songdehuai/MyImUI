package com.songdehuai.immsglist.adapter;

import android.content.Context;
import android.gesture.GestureLibraries;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

    public void setListMsg(List<Msg> listMsg) {
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


    MsgReceiveViewHolder receiveViewHolder = null;
    MsgSendViewHolder sendViewHolder = null;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = listMsg.get(position);
//        switch (msg.getType()) {
//            case "receive_text":
//                if (null == receiveViewHolder) {
//                    convertView = View.inflate(context, R.layout.item_msg_receive, null);
//                    receiveViewHolder = new MsgReceiveViewHolder(convertView);
//                    convertView.setTag(R.id.receive_text, receiveViewHolder);
//                } else {
//                    receiveViewHolder = (MsgReceiveViewHolder) convertView.getTag(R.id.receive_text);
//                }
//                //接收的消息
//                receiveViewHolder.text.setText(msg.getText());
//                break;
//            case "send_text":
//                if (null == sendViewHolder) {
//                    convertView = View.inflate(context, R.layout.item_msg_send, null);
//                    sendViewHolder = new MsgSendViewHolder(convertView);
//                    convertView.setTag(R.id.send_text, sendViewHolder);
//                } else {
//                    sendViewHolder = (MsgSendViewHolder) convertView.getTag(R.id.send_text);
//                }
//
//                //发送的消息
//                sendViewHolder.text.setText(msg.getText());
//                break;
//        }
        if (msg.getType().equals("receive_text")) {
            convertView = View.inflate(context, R.layout.item_msg_receive, null);
            receiveViewHolder = new MsgReceiveViewHolder(convertView);
            //接收的消息
            receiveViewHolder.text.setText(msg.getText());
        } else if (msg.getType().equals("send_text")) {
            convertView = View.inflate(context, R.layout.item_msg_send, null);
            sendViewHolder = new MsgSendViewHolder(convertView);
            //发送的消息
            sendViewHolder.text.setText(msg.getText());
        }

        return convertView;
    }


    public static class MsgSendViewHolder {

        ImageView imageView;
        TextView text;

        public MsgSendViewHolder(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.msg_send_img);
            text = (TextView) itemView.findViewById(R.id.msg_send_text);
        }
    }


    public static class MsgReceiveViewHolder {
        ImageView imageView;
        TextView text;

        public MsgReceiveViewHolder(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.msg_receive_img);
            text = (TextView) itemView.findViewById(R.id.msg_receive_text);
        }
    }

}
