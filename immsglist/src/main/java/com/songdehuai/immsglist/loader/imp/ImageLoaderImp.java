package com.songdehuai.immsglist.loader.imp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.songdehuai.immsglist.loader.ImageLoader;

/**
 * 描述：图片加载器
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.immsglist.loader.ImageLoaderImp
 * @date 2017/7/30 15:53
 */
public class ImageLoaderImp implements ImageLoader {

    @Override
    public void imageLoad(Context context, String uri, ImageView imageView) {
        Glide.with(context).load(uri).into(imageView);
    }
}
