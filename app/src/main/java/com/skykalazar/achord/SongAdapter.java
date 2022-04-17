package com.skykalazar.achord;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewModel> {


    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        public ViewModel(@NonNull View itemView) {
            super(itemView);
        }
    }
}
