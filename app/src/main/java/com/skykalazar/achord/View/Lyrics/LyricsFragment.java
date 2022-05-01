package com.skykalazar.achord.View.Lyrics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.skykalazar.achord.ViewModel.Songs.SongsViewModel;
import com.skykalazar.achord.databinding.LyricsFragmentBinding;

import java.util.Objects;


public class LyricsFragment extends Fragment {

    private LyricsFragmentBinding binding;
    private SongsViewModel songsViewModel;
    private EditText lyrics;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = LyricsFragmentBinding.inflate(inflater, container, false);

        lyrics = binding.currentLyrics;

        lyrics.setText(Objects.requireNonNull(songsViewModel.getCurrentSong().getValue()).getLyrics());
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}