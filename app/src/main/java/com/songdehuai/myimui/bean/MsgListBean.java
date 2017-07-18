package com.songdehuai.myimui.bean;

/**
 * Created by Doracoin on 2017/7/18.
 */
public class MsgListBean {
    //聊天对象名称
    private String obj_name;
    //聊天对象ID
    private long obj_id;
    //聊天对象最近消息日期
    private long obj_date;
    //聊天对象头像路径
    private String obj_avatar_path;
    //最近消息内容
    private String obj_recent_message;

    public String getObj_name() {
        return obj_name;
    }

    public void setObj_name(String obj_name) {
        this.obj_name = obj_name;
    }

    public long getObj_id() {
        return obj_id;
    }

    public void setObj_id(long obj_id) {
        this.obj_id = obj_id;
    }

    public long getObj_date() {
        return obj_date;
    }

    public void setObj_date(long obj_date) {
        this.obj_date = obj_date;
    }

    public String getObj_avatar_path() {
        return obj_avatar_path;
    }

    public void setObj_avatar_path(String obj_avatar_path) {
        this.obj_avatar_path = obj_avatar_path;
    }

    public String getObj_recent_message() {
        return obj_recent_message;
    }

    public void setObj_recent_message(String obj_recent_message) {
        this.obj_recent_message = obj_recent_message;
    }
}
