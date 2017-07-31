package com.volleyapplication2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by syed on 28/7/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    private List<ItemObject> itemList;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        mContext = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView songTitle;
        public TextView songYear;
        public TextView songAuthor;
        public MyViewHolder(View itemView) {
            super(itemView);

            songTitle = (TextView)itemView.findViewById(R.id.song_title);
            songYear = (TextView)itemView.findViewById(R.id.song_year);
            songAuthor = (TextView)itemView.findViewById(R.id.song_author);
        }
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.songTitle.setText("Song Title: " + itemList.get(position).getSongTitle());
        holder.songYear.setText("Song Year: " + itemList.get(position).getSongYear());
        holder.songAuthor.setText("Song Author: " + itemList.get(position).getSongAuthor());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
