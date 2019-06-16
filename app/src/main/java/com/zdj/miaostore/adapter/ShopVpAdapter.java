package com.zdj.miaostore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zdj.miaostore.util.HpShopFragmentCreator;

public class ShopVpAdapter extends FragmentPagerAdapter {

    public ShopVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return HpShopFragmentCreator.getFragment(i);
    }

    @Override
    public int getCount() {
        return HpShopFragmentCreator.PAGE_COUNT;
    }
}
