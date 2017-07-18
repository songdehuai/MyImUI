package com.songdehuai.myimui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.songdehuai.myimui.R;

import org.xutils.x;

/**
 * 描述：主页
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.myimui.fragment. MainFragment
 * @date 2017/7/18 20:23
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_main, null);
        x.view().inject(this, view);
        return view;
    }
}
