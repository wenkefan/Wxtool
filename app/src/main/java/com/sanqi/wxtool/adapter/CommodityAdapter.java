package com.sanqi.wxtool.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sanqi.wxtool.R;
import com.sanqi.wxtool.base.CommodityBase;
import com.sanqi.wxtool.weight.RatioImageView;

import java.util.List;

/**
 * Created by 范文轲 on 2017/9/21.
 */

public class CommodityAdapter extends AbsRecyclerViewAdapter {

    private List<CommodityBase.NTbkItemBean> commodityList;

    public CommodityAdapter(RecyclerView recyclerView, List<CommodityBase.NTbkItemBean> commodityList) {
        super(recyclerView);
        this.commodityList = commodityList;
        Log.d("fan",commodityList.size()+"---size");
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.commodity_list,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder){
            ItemViewHolder holde = (ItemViewHolder) holder;
            Glide.with(getContext())
                    .load(commodityList.get(position).getPict_url())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.placeholder_image)
                    .into(holde.rationImageView);
            holde.rationImageView.setTag(R.string.app_name,commodityList.get(position).getPict_url());
            holde.title.setText(commodityList.get(position).getTitle());
            holde.introduce.setText(commodityList.get(position).getZk_final_price());
            holde.sendOut.setText("未发送");
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return commodityList != null ? commodityList.size() : 0;
    }

    public class ItemViewHolder extends ClickableViewHolder{

        public RatioImageView rationImageView;

        public TextView title,introduce,sendOut;

        public ItemViewHolder(View itemView) {
            super(itemView);
            rationImageView = $(R.id.iv_comm_img);
            title = $(R.id.tv_comm_title);
            introduce = $(R.id.tv_comm_introduce);
            sendOut = $(R.id.tv_comm_sendOut);
        }
    }
}
