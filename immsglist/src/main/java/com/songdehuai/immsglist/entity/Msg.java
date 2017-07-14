package com.songdehuai.immsglist.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 描述：消息
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.immsglist.entity. Msg
 * @date 2017/7/14 16:07
 */
public class Msg {


    /**
     * id :
     * name :
     * img :
     * text :
     * type :
     * time :
     */

    private String id;
    private String name;
    private String img;
    private String text;
    private String type;
    private String time;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
