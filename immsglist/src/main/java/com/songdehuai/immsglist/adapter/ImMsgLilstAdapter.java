package com.songdehuai.immsglist.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.songdehuai.immsglist.R;
import com.songdehuai.immsglist.entity.Msg;

import org.xutils.x;

import java.util.List;

/**
 * 描述：消息列表适配器
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.immsglist.adapter.ImMsgLilstAdapter
 * @date 2017/7/17 9:42
 */
public class ImMsgLilstAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<Msg> msgList;
    public Context context;


    public void setListMsg(List<Msg> msgList) {
        this.msgList = msgList;
    }

    public ImMsgLilstAdapter(Context context, List<Msg> msgList) {
        this.context = context;
        this.msgList = msgList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        if (viewType == 0) {
            rootView = LayoutInflater.from(context).inflate(R.layout.item_msg_receive, parent, false);
            ReceiveTextViewHolder receiveViewHolder = new ReceiveTextViewHolder(rootView);
            return receiveViewHolder;
        } else if (viewType == 1) {
            rootView = LayoutInflater.from(context).inflate(R.layout.item_msg_send, parent, false);
            SendTextViewHolder sendViewHolder = new SendTextViewHolder(rootView);
            return sendViewHolder;
        } else if (viewType == 3) {
            rootView = LayoutInflater.from(context).inflate(R.layout.item_voice_receive, parent, false);
            return new ReceiveVoiceViewHolder(rootView);
        } else if (viewType == 4) {
            rootView = LayoutInflater.from(context).inflate(R.layout.item_voice_send, parent, false);
            return new SendVoiceViewHolder(rootView);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        String type = msgList.get(position).getType();
        if ("receive_text".equals(type)) {
            return 0;
        } else if ("send_text".equals(type)) {
            return 1;
        } else if ("receive_voice".equals(type)) {
            return 3;
        } else if ("send_voice".equals(type)) {
            return 4;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReceiveTextViewHolder) {
            ReceiveTextViewHolder receiveTextViewHolder = (ReceiveTextViewHolder) holder;
            receiveTextViewHolder.text.setText(msgList.get(position).getText());
            receiveTextViewHolder.setFriendImg(msgList.get(position).getFriendsImg());
        } else if (holder instanceof SendTextViewHolder) {
            SendTextViewHolder sendTextViewHolder = (SendTextViewHolder) holder;
            sendTextViewHolder.text.setText(msgList.get(position).getText());
            sendTextViewHolder.setUserImg(msgList.get(position).getUserImg());
        } else if (holder instanceof ReceiveVoiceViewHolder) {
            ReceiveVoiceViewHolder receiveVoiceViewHolder = (ReceiveVoiceViewHolder) holder;
            receiveVoiceViewHolder.setFriendImg(msgList.get(position).getFriendsImg());
            receiveVoiceViewHolder.text.setText(msgList.get(position).getVoiceLen() + " 秒 ");
        } else if (holder instanceof SendVoiceViewHolder) {
            SendVoiceViewHolder sendVoiceViewHolder = (SendVoiceViewHolder) holder;
            sendVoiceViewHolder.setUserImg(msgList.get(position).getUserImg());
            sendVoiceViewHolder.text.setText(msgList.get(position).getVoiceLen() + " 秒 ");
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    public static class SendVoiceViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public SendVoiceViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.msg_send_voice);
            image = (ImageView) itemView.findViewById(R.id.msg_send_img);
        }

        public void setUserImg(String uri) {
            Glide.with(itemView.getContext()).load(uri).into(image);
        }
    }

    public static class ReceiveVoiceViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ReceiveVoiceViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.msg_send_voice);
            image = (ImageView) itemView.findViewById(R.id.msg_send_img);
        }

        public void setFriendImg(String uri) {
            Glide.with(itemView.getContext()).load(uri).into(image);
        }
    }

    public static class SendTextViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView image;

        public SendTextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.msg_send_text);
            image = (ImageView) itemView.findViewById(R.id.msg_send_img);
        }

        public void setUserImg(String uri) {
            Glide.with(itemView.getContext()).load(uri).into(image);
        }

    }

    public static class ReceiveTextViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public ReceiveTextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.msg_send_text);
            image = (ImageView) itemView.findViewById(R.id.msg_send_img);
        }

        public void setFriendImg(String uri) {
            Glide.with(itemView.getContext()).load(uri).into(image);
        }

    }
}
