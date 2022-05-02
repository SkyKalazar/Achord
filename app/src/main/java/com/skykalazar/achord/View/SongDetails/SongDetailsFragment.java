package com.skykalazar.achord.View.SongDetails;


import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.skykalazar.achord.ViewModel.Songs.SongsViewModel;
import com.skykalazar.achord.databinding.SongDetailsFragmentBinding;

import java.util.Objects;


public class SongDetailsFragment extends Fragment {

    private SongDetailsFragmentBinding binding;
    private SongsViewModel songsViewModel;
    private EditText currentTitle;
    private EditText currentArtist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);
        binding = SongDetailsFragmentBinding.inflate(inflater, container, false);

        currentTitle = binding.CurrentTitle;
        currentArtist = binding.CurrentArtist;

        populateCurrentSongDetails();

        return binding.getRoot();

    }

    private void populateCurrentSongDetails() {
        Song currentSong = songsViewModel.getCurrentSong().getValue();
        if(currentSong != null) {
        currentTitle.setText(currentSong.getTitle());
        currentArtist.setText(currentSong.getArtist());
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);

        binding.ShowLyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.action_nav_songDetailsFragment_to_nav_lyricsFragment);
            }
        });
        binding.SaveSongDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(songsViewModel.getCurrentSong().getValue()).setTitle(currentTitle.getText().toString());
                Objects.requireNonNull(songsViewModel.getCurrentSong().getValue()).setArtist(currentArtist.getText().toString());
                songsViewModel.updateSong();
                NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.details_to_home);
            }
        });
        binding.DeleteSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletionAlert();
            }
        });
        binding.ShowTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.details_to_timer);
            }
        });
    }

    public void deletionAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(binding.getRoot().getContext());
        builder.setTitle("Delete " + currentTitle.getText());
        builder.setMessage("Are you sure you want to delete this?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                songsViewModel.deleteSong();
                NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.details_to_home);
            }
        }).setNegativeButton("Cancel", null);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}