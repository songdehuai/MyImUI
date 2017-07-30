package com.songdehuai.immsglist.loader;

import android.content.Context;
import android.widget.ImageView;

/**
 * 描述：图片加载器
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.immsglist.loader.ImageLoader
 * @date 2017/7/30 15:53
 */
public interface ImageLoader {

    void imageLoad(Context context, String uri, ImageView imageView);
}
