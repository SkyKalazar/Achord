package com.skykalazar.achord.View.Songs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.R;
import com.skykalazar.achord.ViewModel.Songs.SongsViewModel;
import com.skykalazar.achord.databinding.SongsFragmentBinding;

import java.util.List;


public class SongsFragment extends Fragment implements SongsAdapter.SongOnClickListener {

    private SongsFragmentBinding binding;
    private RecyclerView recyclerView;
    private SongsViewModel songsViewModel;
    private SongsAdapter.SongOnClickListener callback;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = SongsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.rv1;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.hasFixedSize();

        callback = this;


        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);

        songsViewModel.getSongs().observe(getViewLifecycleOwner(), songs -> {
            //Set songs through mutator, not constructor. Notify dataset changed
            recyclerView.setAdapter(new SongsAdapter(songs, callback));
        });
        binding.AddSong.setOnClickListener(view1 ->
                NavHostFragment.findNavController(SongsFragment.this).navigate(R.id.action_nav_songs_to_nav_AddSong));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(Song song) {
        songsViewModel.setCurrentSong(song);
        NavHostFragment.findNavController(SongsFragment.this).navigate(R.id.action_nav_songs_to_nav_songDetailsFragment);
    }
}