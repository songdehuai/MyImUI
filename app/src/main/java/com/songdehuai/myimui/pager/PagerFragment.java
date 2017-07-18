package com.songdehuai.myimui.pager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Doracoin on 2017/7/18.
 */
public class PagerFragment extends Fragment {
    private BasePager basePager;

    public PagerFragment(BasePager basePager) {
        this.basePager = basePager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (basePager != null) {
            return basePager.rootView;
        }
        return null;
    }
}
