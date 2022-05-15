package com.skykalazar.achord.View.AddSong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.R;
import com.skykalazar.achord.ViewModel.SongsViewModel;
import com.skykalazar.achord.databinding.AddSongFragmentBinding;


public class AddSongFragment extends Fragment {

    private AddSongFragmentBinding binding;
    private SongsViewModel songsViewModel;
    private EditText title;
    private EditText artist;
    private EditText lyrics;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = AddSongFragmentBinding.inflate(inflater, container, false);
        title = binding.NewTitle;
        artist = binding.NewArtist;
        lyrics = binding.NewLyrics;
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);


        binding.buttonSave.setOnClickListener(view1 -> {
            songsViewModel.addSong(new Song(title.getText().toString(), artist.getText().toString(), lyrics.getText().toString()));
            NavHostFragment.findNavController(AddSongFragment.this).navigate(R.id.action_nav_AddSong_to_nav_songs);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}