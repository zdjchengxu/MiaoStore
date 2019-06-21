package com.zdj.miaostore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.BuyCarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvBuyCarAdapter extends RecyclerView.Adapter<RvBuyCarAdapter.ViewHolder> {

    private Context mContext;
    private List<BuyCarBean.DataBean.ListBean> mDataList;

    public void setData(List<BuyCarBean.DataBean.ListBean> dataList) {
        this.mDataList = dataList;
        notifyDataSetChanged();
    }

    public RvBuyCarAdapter(Context mContext) {
        this.mContext = mContext;
        this.mDataList = new ArrayList<>();
    }
    @NonNull
    @Override
    public RvBuyCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lv_buycar_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvBuyCarAdapter.ViewHolder viewHolder, int position) {
        viewHolder.tvShoppcardbaseIdBuycar.setText(mDataList.get(position).getShoppcardbaseId());
        viewHolder.tvShoppcardbaseSumBuycar.setText(mDataList.get(position).getShoppcardbaseSum()+"");
        viewHolder.tvTimeBuycar.setText(mDataList.get(position).getShoppcardbaseTime()+"");
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvShoppcardbaseIdBuycar;
        TextView tvTimeBuycar;
        TextView tvShoppcardbaseSumBuycar;

        public ViewHolder(View view) {
            super(view);
            Log.e("tag", "加来了");
            tvShoppcardbaseIdBuycar = view.findViewById(R.id.tv_shoppcardbaseId_buycar);
            tvShoppcardbaseSumBuycar = view.findViewById(R.id.tv_shoppcardbaseSum_buycar);
            tvTimeBuycar = view.findViewById(R.id.tv_time_buycar);
        }
    }
}
