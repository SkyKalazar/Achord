package com.skykalazar.achord.View.Songs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.R;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    List<Song> songs;
    SongOnClickListener songListener;

    public SongsAdapter(List<Song> songs, SongOnClickListener songListener) {
        this.songs = songs;
        this.songListener = songListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.song_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(songs.get(position).getTitle());
        holder.artist.setText(songs.get(position).getArtist());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView artist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    songListener.onClick(songs.get(getAdapterPosition()));
                }
            });

            title = itemView.findViewById(R.id.Title);
            artist = itemView.findViewById(R.id.Artist);
        }
    }
    public  interface SongOnClickListener {

        void onClick(Song song);
    }
}
