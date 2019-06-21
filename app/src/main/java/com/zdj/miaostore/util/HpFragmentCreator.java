package com.zdj.miaostore.util;

import com.zdj.miaostore.base.BaseFragment;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.fragments.BuycarFragment;
import com.zdj.miaostore.fragments.MineFragment;
import com.zdj.miaostore.fragments.ShopFragment;
import com.zdj.miaostore.fragments.SpaceFragment;

import java.util.HashMap;
import java.util.Map;

public class HpFragmentCreator {

    public final static int INDEX_SHOP = 0;//商城
    public final static int INDEX_SPACE = 1;//空间
    public final static int INDEX_BUYCAR = 2;//购物车
    public final static int INDEX_MINE = 3;//个人中心

    public final static int PAGE_COUNT = 4;

    private static Map<Integer,BaseFragmentS<BaseView,BasePresenter<BaseView>>> sCache = new HashMap<>();

    public static BaseFragmentS getFragment(int index){
        BaseFragmentS baseFragment = sCache.get(index);
        if(baseFragment != null){
            return baseFragment;
        }
        switch (index){
            case INDEX_SHOP:
                baseFragment = new ShopFragment();
                break;
            case INDEX_SPACE:
                baseFragment = new SpaceFragment();
                break;
            case INDEX_BUYCAR:
                baseFragment = new BuycarFragment();
                break;
            case INDEX_MINE:
                baseFragment = new MineFragment();
                break;
        }
        sCache.put(index,baseFragment);
        return baseFragment;
    }

}
