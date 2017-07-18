package com.songdehuai.myimui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.songdehuai.myimui.R;
import com.songdehuai.myimui.bean.MsgListBean;
import com.songdehuai.myimui.utils.DateFormater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doracoin on 2017/7/18.
 */
public class MsgListAdapter extends BaseAdapter {
    private List<MsgListBean> msgList = new ArrayList<>();
    private Context context;

    public MsgListAdapter(Context context) {
        this.context = context;
    }

    /**
     * 获取内部List
     *
     * @return
     */
    public List<MsgListBean> getInnerList() {
        return msgList;
    }

    /**
     * 刷新
     */
    public void refresh() {
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return msgList.size();
    }

    @Override
    public MsgListBean getItem(int position) {
        return msgList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return msgList.get(position).getObj_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_msglist, null);
            holder = new Holder();
            holder.txtName = (TextView) convertView.findViewById(R.id.item_txt_user_name);
            holder.txtRecent = (TextView) convertView.findViewById(R.id.item_txt_recent_message);
            holder.txtDate = (TextView) convertView.findViewById(R.id.item_txt_recent_date);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.txtName.setText(msgList.get(position).getObj_name());
        holder.txtRecent.setText(msgList.get(position).getObj_recent_message());
        holder.txtDate.setText(DateFormater.format(msgList.get(position).getObj_date(), "HH:mm"));
        return convertView;
    }

    private class Holder {
        TextView txtName, txtRecent, txtDate;
        ImageView imgAvatar;
    }
}
