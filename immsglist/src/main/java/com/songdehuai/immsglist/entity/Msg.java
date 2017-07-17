package com.songdehuai.immsglist.entity;

import android.net.Uri;
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
    private String img;
    private String text;
    private String type;
    private String time;
    private Uri uri;
    private String userImg;
    private String userName;
    private String friendImg;
    private String friendName;
    /////////////////////////////////////
    //语音
    private String voiceUri;
    private String voiceLen;

    public void setFriendImg(String friendImg) {
        this.friendImg = friendImg;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public void setVoiceUri(String voiceUri) {
        this.voiceUri = voiceUri;
    }

    public void setVoiceLen(String voiceLen) {
        this.voiceLen = voiceLen;
    }

    public String getFriendImg() {
        return friendImg;
    }

    public String getFriendName() {
        return friendName;
    }

    public String getVoiceUri() {
        return voiceUri;
    }

    public String getVoiceLen() {
        return voiceLen;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFriendsImg(String friendsImg) {
        this.friendImg = friendsImg;
    }

    public void setFriendsName(String friendsName) {
        this.friendName = friendsName;
    }

    public String getUserImg() {
        return userImg;
    }

    public String getUserName() {
        return userName;
    }

    public String getFriendsImg() {
        return friendImg;
    }

    public String getFriendsName() {
        return friendName;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
