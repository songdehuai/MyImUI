package com.songdehuai.immsglist.adapter.itemviewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.songdehuai.immsglist.R;
import com.songdehuai.immsglist.entity.Msg;
import com.songdehuai.immsglist.loader.ImageLoader;
import com.songdehuai.immsglist.loader.imp.ImageLoaderImp;

/**
 * 描述：BaseViewHolder
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.immsglist.adapter.itemviewholder.BaseViewHolder
 * @date 2017/7/30 15:42
 */
public class BaseReceiveViewHolder extends RecyclerView.ViewHolder {

    public BaseReceiveViewHolder(View itemView) {
        super(itemView);
    }


    private Msg msg;
    private ImageView imageView;
    private ImageLoader imageLoader;

    public BaseReceiveViewHolder(View itemView, Msg msg) {
        super(itemView);
        this.msg = msg;
        imageLoader = new ImageLoaderImp();
        setFriendHead();
    }


    private void setFriendHead() {
        imageView = (ImageView) itemView.findViewById(R.id.msg_receive_img);
        imageLoader.imageLoad(itemView.getContext(), msg.getUserImg(), imageView);
    }

}
