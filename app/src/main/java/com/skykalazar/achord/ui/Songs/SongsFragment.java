package com.skykalazar.achord.UI.Songs;

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
import com.skykalazar.achord.databinding.FragmentSongsBinding;

import java.util.ArrayList;


public class SongsFragment extends Fragment {

    private FragmentSongsBinding binding;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SongsViewModel songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = FragmentSongsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.rv1;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.hasFixedSize();


        songsViewModel.getSongs().observe(getViewLifecycleOwner(), new Observer<ArrayList<Song>>() {
            @Override
            public void onChanged(ArrayList<Song> songs) {
                recyclerView.setAdapter(new SongsAdapter(songs));
            }
        });
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.AddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SongsFragment.this)
                        .navigate(R.id.action_nav_songs_to_nav_AddSong);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}