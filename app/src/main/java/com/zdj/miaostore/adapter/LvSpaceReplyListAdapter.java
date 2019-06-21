package com.zdj.miaostore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.SpaceBean;

import java.util.List;

class LvSpaceReplyListAdapter extends BaseAdapter {

    private Context mContext;
    private List<SpaceBean.DataBean.ListBean.ListReplyBean> mReplyBeanList;

    public LvSpaceReplyListAdapter(Context mContext, List<SpaceBean.DataBean.ListBean.ListReplyBean> replyBeanList) {
        this.mContext = mContext;
        this.mReplyBeanList = replyBeanList;
    }

    @Override
    public int getCount() {
        return mReplyBeanList == null ? 0 : mReplyBeanList.size();
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
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_space_replylist_item,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvUserName.setText(mReplyBeanList.get(position).getUserBaseSecoundUser().getUsername());
        viewHolder.tvContent.setText("："+mReplyBeanList.get(position).getSpaceContent());

        return convertView;
    }

    private class ViewHolder{
        TextView tvUserName;
        TextView tvContent;

        ViewHolder(View itemView){
            tvContent = itemView.findViewById(R.id.tv_content_space_reply_lv_item);
            tvUserName = itemView.findViewById(R.id.tv_username_space_reply_lv_item);
        }

    }

}
