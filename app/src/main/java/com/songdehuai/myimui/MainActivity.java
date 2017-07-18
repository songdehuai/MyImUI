package com.songdehuai.myimui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.songdehuai.myimui.pager.BasePager;
import com.songdehuai.myimui.pager.MsgListPager;
import com.songdehuai.myimui.pager.PagerFragment;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private List<BasePager> basePagers;
    private int position = 0;
    private RadioGroup radioGroupBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initPager();
    }

    private void initViews() {
        radioGroupBottom = (RadioGroup) findViewById(R.id.act_main_bottom_radio);
    }

    private void initPager(){
        basePagers = new ArrayList<BasePager>();
        basePagers.add(new MsgListPager(this));
        basePagers.add(new MsgListPager(this));
        basePagers.add(new MsgListPager(this));
        radioGroupBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    default:
                        position = 0;
                        break;
                    case R.id.act_main_bottom_radio_msglist:
                        position = 0;
                        break;
                    case R.id.act_main_bottom_radio_contact:
                        position = 1;
                        break;
                    case R.id.act_main_bottom_radio_more:
                        position = 2;
                        break;
                }
                setFragment();
            }
        });
        //默认选中第一个
        radioGroupBottom.check(R.id.act_main_bottom_radio_msglist);
    }

    private void setFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.act_main_top_fragments, new PagerFragment(getBasePager())).commit();
    }

    private BasePager getBasePager() {
        BasePager basePager = basePagers.get(position);
        if (basePager != null && !basePager.isInit) {
            basePager.initData();
            basePager.isInit = true;
        }
        return basePager;
    }

}
