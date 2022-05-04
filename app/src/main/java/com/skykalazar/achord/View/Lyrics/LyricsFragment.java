package com.skykalazar.achord.View.Lyrics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.skykalazar.achord.R;
import com.skykalazar.achord.View.Songs.SongsFragment;
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
        binding.saveNewLyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Law of the meter. Just set lyrics on the current song. Tell, don't ask
                Objects.requireNonNull(songsViewModel.getCurrentSong().getValue()).setLyrics(lyrics.getText().toString());
                songsViewModel.updateSong();
                NavHostFragment.findNavController(LyricsFragment.this).navigate(R.id.action_from_Lyrics_to_Details);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}