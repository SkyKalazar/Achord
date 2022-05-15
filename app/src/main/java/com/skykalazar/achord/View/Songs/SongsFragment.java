package com.skykalazar.achord.View.Songs;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.R;
import com.skykalazar.achord.ViewModel.SongsViewModel;
import com.skykalazar.achord.databinding.SongsFragmentBinding;


public class SongsFragment extends Fragment implements SongsAdapter.SongOnClickListener {

    private SongsFragmentBinding binding;
    private RecyclerView recyclerView;
    private SongsViewModel songsViewModel;
    private SongsAdapter.SongOnClickListener callback;
    private SongsAdapter adapter;


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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new SongsAdapter(callback);
        recyclerView.setAdapter(adapter);

        songsViewModel.getSongs().observe(getViewLifecycleOwner(), songs -> {
            adapter.setSongs(songs);
        });
        binding.SearchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                adapter.setSongs(songsViewModel.masterFilter(editable.toString(), binding.FilterFavourites.isChecked()));
            }
        });
        binding.FilterFavourites.setOnClickListener(view12 -> {
                adapter.setSongs(songsViewModel.masterFilter(binding.SearchField.getText().toString(), binding.FilterFavourites.isChecked()));
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
    public void onResume() {
        super.onResume();
        binding.SearchField.getText().clear();
        binding.FilterFavourites.setChecked(false);
    }

    @Override
    public void onClick(Song song) {
        songsViewModel.setCurrentSong(song);
        NavHostFragment.findNavController(SongsFragment.this).navigate(R.id.action_nav_songs_to_nav_songDetailsFragment);
    }
}