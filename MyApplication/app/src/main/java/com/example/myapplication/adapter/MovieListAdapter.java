package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.MovieData;
import com.example.myapplication.network.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private List<MovieData> movieDatas;
    private Context context;
    private OnMovieItemSelectedListener onMovieItemSelectedListener;

    public MovieListAdapter(Context context){
        this.context = context;
        movieDatas = new ArrayList<>();
    }

    public void add(MovieData item){
        movieDatas.add(item);
        notifyItemInserted(movieDatas.size() - 1);
    }

    public void addAll(List<MovieData> movieDatas){
        for(MovieData movieData : movieDatas){
            add(movieData);
        }
    }

    public void remove(MovieData item){
        int position = movieDatas.indexOf(item);
        if(position > -1){
            movieDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

    public  void clear(){
        while(getItemCount() > 0){
            remove(getItem(0));
        }
    }

    private MovieData getItem(int i) {
        return movieDatas.get(i);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        final MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = movieViewHolder.getAdapterPosition();
                if(adapterPos != RecyclerView.NO_POSITION){
                    if(onMovieItemSelectedListener != null){
                        onMovieItemSelectedListener.onItemClick(movieViewHolder.itemView, adapterPos);
                    }
                }
            }
        });
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final MovieData movieData = movieDatas.get(position);
        holder.bind(movieData);
    }

    @Override
    public int getItemCount() {
        return movieDatas.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img_preview);
        }

        public void bind(MovieData movieData) {
            Picasso.get().load(Constant.IMG_URL+movieData.getPoster_path()).into(img);
        }
    }

    public void setOnMovieItemSelectedListener(OnMovieItemSelectedListener onMovieItemSelectedListener){
        this.onMovieItemSelectedListener = onMovieItemSelectedListener;
    }

    public interface OnMovieItemSelectedListener {
        void onItemClick(View v, int position);
    }
}
