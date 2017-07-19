package com.songdehuai.myimui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.songdehuai.myimui.adapter.ViewPagerAdapter;
import com.songdehuai.myimui.fragment.ChatListFragment;
import com.songdehuai.myimui.fragment.MainFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 描述：
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.myimui. ChatMainActivity
 * @date 2017/7/18 20:18
 */

public class ChatMainActivity extends AppCompatActivity {

    @ViewInject(R.id.chat_tablayout)
    TabLayout tablayout;
    @ViewInject(R.id.chat_viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatmain);
        x.view().inject(this);
        initViews();
    }


    private void initViews() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(new ChatListFragment(), "列表");
        viewPagerAdapter.addFrag(new MainFragment(), "主页");
        viewPagerAdapter.addFrag(new MainFragment(), "更多");
        viewPager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewPager);
        initTablayout();
    }

    void initTablayout() {
        TabLayout.Tab tabList = null, tabMain = null, tabMore = null;
        tabList = tablayout.getTabAt(0);
        tabMain = tablayout.getTabAt(1);
        tabMore = tablayout.getTabAt(2);
        tabList.setIcon(R.drawable.ic_face_black);
        tabMain.setIcon(R.drawable.ic_sms_black);
        tabMore.setIcon(R.drawable.ic_more_horiz_black);
    }
}

