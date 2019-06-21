package com.zdj.miaostore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.HomePageBean;
import com.zdj.miaostore.interfaces.OnRecommendCardViewClickListener;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.LogUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RvRecommendAdapter extends RecyclerView.Adapter<RvRecommendAdapter.RecomendHolder> {

    private List<Serializable> dataList;
    private Context context;
    private int size = 0;
    private static final String TAG = "RvRecommendAdapter";
    private OnRecommendCardViewClickListener mOnClick;

    public void setmOnClick(OnRecommendCardViewClickListener mOnClick) {
        this.mOnClick = mOnClick;
    }

    public RvRecommendAdapter(Context context) {
        this.context = context;
        this.dataList = new ArrayList<>();
    }

    public void setData(List<Serializable> dataList) {
        this.dataList = dataList;
        LogUtil.e(TAG, "size" + dataList.size());
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position) instanceof HomePageBean.DataBean.ListAdvBean) {
            return Contans.ADV_TYPE_RECOMMEND;
        } else if (dataList.get(position) instanceof HomePageBean.DataBean.ListShopRecommendBean) {
            return Contans.SHOP_TYPE_RECOMMEND;
        } else
            return 0;

    }

    @NonNull
    @Override
    public RvRecommendAdapter.RecomendHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RvRecommendAdapter.RecomendHolder holder = null;
        View itemView;
        switch (i) {
            case Contans.ADV_TYPE_RECOMMEND:
                itemView = LayoutInflater.from(context).inflate(R.layout.rv_recommend_adv, viewGroup, false);
                holder = new AdvHolder(itemView);
                break;
            case Contans.SHOP_TYPE_RECOMMEND:
                itemView = LayoutInflater.from(context).inflate(R.layout.rv_recommend_shop, viewGroup, false);
                holder = new ShopsHolder(itemView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecomendHolder recomendHolder, final int position) {
        if (recomendHolder instanceof ShopsHolder) {
            HomePageBean.DataBean.ListShopRecommendBean recommendBean = (HomePageBean.DataBean.ListShopRecommendBean) dataList.get(position);
            Glide.with(context).load(Contans.URL_SHOP + recommendBean.getShopThumbnail()).into(((ShopsHolder) recomendHolder).ivImg);
            ((ShopsHolder) recomendHolder).tvAdd.setText(recommendBean.getShopAddress());
            ((ShopsHolder) recomendHolder).tvDesc.setText(recommendBean.getShopDesc());
            ((ShopsHolder) recomendHolder).tvPrice.setText(recommendBean.getShopPrice() + "");
            ((ShopsHolder) recomendHolder).cvContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClick != null) {
                        mOnClick.onClick(position);
                    }
                }
            });
        }
        if (recomendHolder instanceof AdvHolder) {
            HomePageBean.DataBean.ListAdvBean advBean = (HomePageBean.DataBean.ListAdvBean) dataList.get(position);
            Glide.with(context)
                    .load(Contans.URL_SHOP + advBean.getAdvertisingImg())
                    .placeholder(R.mipmap.jiazaizhong)
                    .error(R.mipmap.tupianjiazaishibai)
                    .into(((AdvHolder) recomendHolder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    private class ShopsHolder extends RecomendHolder {
        public ShopsHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class AdvHolder extends RecomendHolder {

        ImageView imageView;

        public AdvHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_adv_recycle);
        }
    }

    protected class RecomendHolder extends RecyclerView.ViewHolder {

        TextView tvAdd;
        TextView tvDesc;
        TextView tvPrice;
        CardView cvContent;
        ImageView ivImg;

        public RecomendHolder(@NonNull View itemView) {
            super(itemView);
            tvAdd = itemView.findViewById(R.id.tv_recommend_shop_add);
            tvDesc = itemView.findViewById(R.id.tv_recommend_shop_desc);
            tvPrice = itemView.findViewById(R.id.tv_recommend_shop_price);
            ivImg = itemView.findViewById(R.id.iv_recommend_shop_img);
            cvContent = itemView.findViewById(R.id.cv_content_recommend);
        }
    }


}
