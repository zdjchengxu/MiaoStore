package com.zdj.miaostore.adapter;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.CategoryDataBean;
import com.zdj.miaostore.util.Contans;

import java.util.List;

public class RvChairAdapter extends RecyclerView.Adapter<RvChairAdapter.RvChariHolder> {

    private Context mContext;
    private List<CategoryDataBean.DataBean.ListBean> datalist;

    public RvChairAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDatalist(List<CategoryDataBean.DataBean.ListBean> datalist) {
        this.datalist = datalist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RvChairAdapter.RvChariHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_chair_item,viewGroup,false);
        return new RvChariHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvChairAdapter.RvChariHolder rvChariHolder, int position) {
        Glide.with(mContext).load(Contans.URL_SHOP+datalist.get(position).getShopThumbnail()).into(rvChariHolder.ivImg);
        rvChariHolder.tvPrice.setText(datalist.get(position).getShopPrice()+"");
        rvChariHolder.tvDesc.setText(datalist.get(position).getShopDesc());
    }

    @Override
    public int getItemCount() {
        return datalist == null?0:datalist.size();
    }

    public class RvChariHolder extends RecyclerView.ViewHolder {
        TextView tvDesc;
        TextView tvPrice;
        ImageView ivImg;
        public RvChariHolder(@NonNull View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tv_chair_shop_desc);
            tvPrice = itemView.findViewById(R.id.tv_chair_shop_price);
            ivImg = itemView.findViewById(R.id.iv_chair_shop_img);
        }
    }
}
