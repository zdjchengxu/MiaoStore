package com.zdj.miaostore.util;

import com.zdj.miaostore.base.BaseFragment;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.fragments.ChairFragment;
import com.zdj.miaostore.fragments.DrinkFragment;
import com.zdj.miaostore.fragments.RecommendFragment;

import java.util.HashMap;
import java.util.Map;

public class HpShopFragmentCreator {

    public final static int INDEX_RECOMMEND = 0;//推荐
    public final static int INDEX_DRINKS = 1;//饮料
    public final static int INDEX_CHAIR = 2;//电脑椅
    public final static int PAGE_COUNT = 3;

    private static Map<Integer,BaseFragmentS<BaseView,BasePresenter<BaseView>>> sCache = new HashMap<>();

    public static BaseFragmentS getFragment(int index) {
        BaseFragmentS baseFragment = sCache.get(index);
        if (baseFragment != null) {
            return baseFragment;
        }
        switch (index) {
            case INDEX_RECOMMEND:
                baseFragment = new RecommendFragment();
                break;
            case INDEX_DRINKS:
                baseFragment = new DrinkFragment();
                break;
            case INDEX_CHAIR:
                baseFragment = new ChairFragment();
                break;
        }
        sCache.put(index, baseFragment);
        return baseFragment;
    }

}
