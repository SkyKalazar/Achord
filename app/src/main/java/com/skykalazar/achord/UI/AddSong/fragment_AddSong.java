package com.skykalazar.achord.UI.AddSong;

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
import com.skykalazar.achord.UI.Songs.SongsFragment;
import com.skykalazar.achord.UI.Songs.SongsViewModel;
import com.skykalazar.achord.databinding.FragmentAddSongBinding;


public class fragment_AddSong extends Fragment {

    private FragmentAddSongBinding binding;
    private SongsViewModel songsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = FragmentAddSongBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);


        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText title = binding.NewTitle;
                EditText artist = binding.NewArtist;
                songsViewModel.addSong(new Song(title.getText().toString(), artist.getText().toString()));
                NavHostFragment.findNavController(fragment_AddSong.this).navigate(R.id.action_nav_AddSong_to_nav_songs);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}