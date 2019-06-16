package com.zdj.miaostore.adapter;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class RvDrinkAdapter extends RecyclerView.Adapter<RvDrinkAdapter.RvDrinkHolder> {

    List<CategoryDataBean.DataBean.ListBean>dataList;
    private Context context;

    public RvDrinkAdapter(Context context) {
        this.context = context;
        this.dataList = new ArrayList<>();
    }

    public void setDataList(List<CategoryDataBean.DataBean.ListBean> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RvDrinkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_drink_item,viewGroup,false);
        RvDrinkHolder rvDrinkHolder = new RvDrinkHolder(view);
        return rvDrinkHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvDrinkHolder rvDrinkHolder, int position) {
        Glide.with(context).load(Contans.URL_SHOP+dataList.get(position).getShopThumbnail()).into(rvDrinkHolder.ivImg);
        rvDrinkHolder.tvPrice.setText(dataList.get(position).getShopPrice()+"");
        rvDrinkHolder.tvDesc.setText(dataList.get(position).getShopDesc());
    }

    @Override
    public int getItemCount() {
        return dataList != null?dataList.size():0;
    }

    public class RvDrinkHolder extends RecyclerView.ViewHolder {

        TextView tvDesc;
        TextView tvPrice;
        ImageView ivImg;

        public RvDrinkHolder(@NonNull View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tv_drink_shop_desc);
            tvPrice = itemView.findViewById(R.id.tv_drink_shop_price);
            ivImg = itemView.findViewById(R.id.iv_drink_shop_img);
        }
    }
}
