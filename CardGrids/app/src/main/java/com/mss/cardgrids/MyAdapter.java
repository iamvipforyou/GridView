package com.mss.cardgrids;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by mss on 4/4/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Movie> myMoviesList;


    public MyAdapter(Context context, ArrayList<Movie> movies) {

        mContext = context;
        myMoviesList = movies;


    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_intheater, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load(myMoviesList.get(position).getmThumbnailImage()).into(holder.poster);

        holder.movieName.setText(myMoviesList.get(position).getmName());
    }

    @Override
    public int getItemCount() {
        return myMoviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView movieName;


        public ViewHolder(View itemView) {
            super(itemView);


            poster = (ImageView) itemView.findViewById(R.id.poster);
            movieName = (TextView) itemView.findViewById(R.id.name);

        }
    }
}
