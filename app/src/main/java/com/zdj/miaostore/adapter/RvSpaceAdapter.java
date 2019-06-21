package com.zdj.miaostore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.SpaceBean;
import com.zdj.miaostore.customview.MyGridView;
import com.zdj.miaostore.customview.MyListView;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RvSpaceAdapter extends RecyclerView.Adapter<RvSpaceAdapter.RvSpaceHolder> {

    private Context mContext;
    private List<SpaceBean.DataBean.ListBean> mDataList;

    public void setDatalist(List<SpaceBean.DataBean.ListBean> datalist) {
        this.mDataList = datalist;
    }

    public RvSpaceAdapter(Context context) {
        this.mContext = context;
        this.mDataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RvSpaceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_space_first_item, viewGroup, false);
        return new RvSpaceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RvSpaceHolder rvSpaceHolder, int position) {
        rvSpaceHolder.tvContent.setText(mDataList.get(position).getSpaceContent());
        rvSpaceHolder.tvName.setText(mDataList.get(position).getUserBase().getUsername());
        rvSpaceHolder.tvTime.setText(stampToDate((long) mDataList.get(position).getSpaceTime()));

        Glide.with(mContext)
                .load(Contans.URL_SHOP + mDataList.get(position).getUserBase().getUserImg())
                .placeholder(R.mipmap.jiazaizhong)
                .error(R.mipmap.tupianjiazaishibai)
                .into(rvSpaceHolder.ivHead);
        List<SpaceBean.DataBean.ListBean.ListImgBean> listImg = mDataList.get(position).getList_img();
        if (listImg != null) {
            rvSpaceHolder.gvImgList.setAdapter(new GvSpaceImgListAdapter(mContext, listImg));
        }
        List<SpaceBean.DataBean.ListBean.ListReplyBean> replyBeanList = mDataList.get(position).getList_reply();
        if (replyBeanList != null) {
            rvSpaceHolder.lvReplyList.setAdapter(new LvSpaceReplyListAdapter(mContext, replyBeanList));
        } else {
            rvSpaceHolder.lvReplyList.setVisibility(View.GONE);
        }
    }

    public static String stampToDate(Long s) {
        s = s * 1000;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(s);
        return simpleDateFormat.format(date);
    }


    @Override
    public int getItemCount() {
        LogUtil.e("geng", mDataList.size() + "size");
        return mDataList == null ? 0 : mDataList.size();
    }

    public class RvSpaceHolder extends RecyclerView.ViewHolder {

        TextView tvContent;
        TextView tvName;
        TextView tvTime;
        ImageView ivHead;
        MyGridView gvImgList;
        MyListView lvReplyList;

        public RvSpaceHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content_spacefirst);
            tvName = itemView.findViewById(R.id.tv_username_spacefirst);
            tvTime = itemView.findViewById(R.id.tv_time_spacefirst);
            ivHead = itemView.findViewById(R.id.iv_head_spacefirst);
            gvImgList = itemView.findViewById(R.id.gv_imglist_space);
            lvReplyList = itemView.findViewById(R.id.lv_replylist_space);
        }
    }
}
