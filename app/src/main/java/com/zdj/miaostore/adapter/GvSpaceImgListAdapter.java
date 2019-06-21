package com.zdj.miaostore.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.SpaceBean;
import com.zdj.miaostore.util.Contans;

import java.util.List;

public class GvSpaceImgListAdapter extends BaseAdapter {

    private Context mContext;
    private List<SpaceBean.DataBean.ListBean.ListImgBean>listImgBeans;

    public GvSpaceImgListAdapter(Context mContext, List<SpaceBean.DataBean.ListBean.ListImgBean> listImg) {
        this.mContext = mContext;
        this.listImgBeans = listImg;
    }

    @Override
    public int getCount() {
        return listImgBeans == null ? 0:listImgBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gv_space_imglist_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Log.e("img",Contans.URL_SHOP+listImgBeans.get(position).getSpaceImgPath());
        Glide.with(mContext)
                .load(Contans.URL_SHOP+listImgBeans.get(position).getSpaceImgPath())
                .placeholder(R.mipmap.jiazaizhong)
                .error(R.mipmap.tupianjiazaishibai)
                .into(holder.ivImg);
        return convertView;
    }

    private class ViewHolder{
        ImageView ivImg;
        ViewHolder(View view){
            ivImg = view.findViewById(R.id.iv_img_gv_space_item);
        }
    }



}
