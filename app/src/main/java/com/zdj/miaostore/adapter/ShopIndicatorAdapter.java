package com.zdj.miaostore.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.zdj.miaostore.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class ShopIndicatorAdapter extends CommonNavigatorAdapter {
    private Context context;
    private final String[] titles;
    private OnIndicatorTapClickListener onIndicatorTapClickListener;

    public void setOnIndicatorTapClickListener(OnIndicatorTapClickListener onIndicatorTapClickListener) {
        this.onIndicatorTapClickListener = onIndicatorTapClickListener;
    }

    public ShopIndicatorAdapter(Context context) {
        this.context = context;
        this.titles = context.getResources().getStringArray(R.array.shop_indicator_name);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText(titles[index]);
        simplePagerTitleView.setTextSize(18);
        simplePagerTitleView.setNormalColor(Color.GRAY);
        simplePagerTitleView.setSelectedColor(Color.WHITE);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onIndicatorTapClickListener != null) {
                    onIndicatorTapClickListener.onTabClick(index);
                }
            }
        });


        return simplePagerTitleView;

    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        BezierPagerIndicator indicator = new BezierPagerIndicator(context);
        indicator.setColors(Color.parseColor("#ff4a42"), Color.parseColor("#fcde64"), Color.parseColor("#73e8f4"), Color.parseColor("#76b0ff"), Color.parseColor("#c683fe"));
        return indicator;
    }

    public interface OnIndicatorTapClickListener {
        void onTabClick(int index);
    }

}