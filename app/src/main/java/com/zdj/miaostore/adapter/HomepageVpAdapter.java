package com.zdj.miaostore.adapter;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zdj.miaostore.util.HpFragmentCreator;

import java.util.List;

public class HomepageVpAdapter extends FragmentPagerAdapter {

    private List<String> mDataList;

    public HomepageVpAdapter(FragmentManager fm, List<String> dataList) {
        super(fm);
        this.mDataList = dataList;
    }


    @Override
    public Fragment getItem(int i) {
        return HpFragmentCreator.getFragment(i);
    }

    @Override
    public int getCount() {
        return HpFragmentCreator.PAGE_COUNT;
    }

    /*@Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(container.getContext());
        textView.setText(mDataList.get(position));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(24);
        container.addView(textView);
        return textView;
    }*/



    /*@Override
    public int getItemPosition(Object object) {
        TextView textView = (TextView) object;
        String text = textView.getText().toString();
        int index = mDataList.indexOf(text);
        if (index >= 0) {
            return index;
        }
        return POSITION_NONE;
    }*/

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }

}
