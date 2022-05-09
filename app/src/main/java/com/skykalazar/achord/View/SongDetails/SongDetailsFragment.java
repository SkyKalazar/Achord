package com.skykalazar.achord.View.SongDetails;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.skykalazar.achord.R;
import com.skykalazar.achord.ViewModel.Songs.SongsViewModel;
import com.skykalazar.achord.databinding.SongDetailsFragmentBinding;




public class SongDetailsFragment extends Fragment {

    private SongDetailsFragmentBinding binding;
    private SongsViewModel songsViewModel;
    private EditText currentTitle;
    private EditText currentArtist;
    private Chronometer timeSpent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);
        binding = SongDetailsFragmentBinding.inflate(inflater, container, false);

        currentTitle = binding.CurrentTitle;
        currentArtist = binding.CurrentArtist;
        timeSpent = binding.DetailsTimeSpent;

        populateCurrentSongDetails();

        return binding.getRoot();

    }

    private void populateCurrentSongDetails() {
        currentTitle.setText(songsViewModel.getTitle());
        currentArtist.setText(songsViewModel.getArtist());
        timeSpent.setBase(SystemClock.elapsedRealtime() - songsViewModel.getTimeSpent());
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);

        binding.ShowLyrics.setOnClickListener(view1 ->
                NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.action_nav_songDetailsFragment_to_nav_lyricsFragment));
        binding.SaveSongDetails.setOnClickListener(view12 -> {
            songsViewModel.setTitle(currentTitle.getText().toString());
            songsViewModel.setArtist(currentArtist.getText().toString());
            NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.details_to_home);
        });
        binding.DeleteSong.setOnClickListener(view13 ->
                deletionAlert());
        binding.ShowTimer.setOnClickListener(view14 ->
                NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.details_to_timer));
    }

    public void deletionAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(binding.getRoot().getContext());
        builder.setTitle("Delete " + currentTitle.getText());
        builder.setMessage("Are you sure you want to delete this?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            songsViewModel.deleteSong();
            NavHostFragment.findNavController(SongDetailsFragment.this).navigate(R.id.details_to_home);
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