package com.kz.dev.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {

    private static final int FIRST_POSITION = 0;
    private List<Integer> mUsersList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    HotAdapter(Context context, List<Integer> colors) {
        this.mInflater = LayoutInflater.from(context);
        this.mUsersList = colors;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = null;
        if (viewType == FIRST_POSITION) {
            view = mInflater.inflate(R.layout.item_hot_first, parent, false);
        } else {
            view = mInflater.inflate(R.layout.item_hot_second, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FIRST_POSITION;
        } else {
            return 1;
        }
    }


    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mSecondItemImage;
        ImageView mFirstItemImage;
        LottieAnimationView lottieAnimationView;
        ViewHolder(View itemView) {
            super(itemView);
            mSecondItemImage = itemView.findViewById(R.id.colorView);
            mFirstItemImage = itemView.findViewById(R.id.hot_first_item);
            lottieAnimationView = itemView.findViewById(R.id.lottieAnimationView);
            itemView.setOnClickListener(this);


        }



        void bind(int position) {
            if (position == 0) {
                LottieDrawable drawable = new LottieDrawable();
                LottieComposition.Factory.fromAssetFileName(context, "hot_round.json",(composition -> {
                    drawable.setComposition(composition);
                    drawable.playAnimation();
                    drawable.setScale(0.13f);
                    lottieAnimationView.setImageDrawable(drawable);
                }));
            } else {
                mSecondItemImage.setImageResource(mUsersList.get(position));
            }
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

    }

    // convenience method for getting data at click position
    public Integer getItem(int id) {
        return mUsersList.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}