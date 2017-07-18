package com.songdehuai.myimui.utils;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Doracoin on 2017/7/18.
 */
public class DateFormater {
    private static final String NORMAL_DATE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将long型 Time格式化为yyyy-MM-dd HH:mm:ss
     *
     * @param millis System.currentMillis();
     * @return "yyyy-MM-dd hh:mm:ss"
     */
    public static String formatSimpleDate(long millis) {
        return format(millis, NORMAL_DATE);
    }

    /**
     * 格式化时间戳
     *
     * @param millis
     * @param template 指定格式
     * @return
     */
    public static String format(long millis, String template) {
        SimpleDateFormat sdf = new SimpleDateFormat(template, Locale.getDefault());
        return sdf.format(new Date(millis));
    }
}
