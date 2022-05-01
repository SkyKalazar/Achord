package com.skykalazar.achord.View.SongDetails;


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
import com.skykalazar.achord.View.AddSong.AddSongFragment;
import com.skykalazar.achord.ViewModel.SongsViewModel;
import com.skykalazar.achord.databinding.AddSongFragmentBinding;


public class SongDetailsFragment extends Fragment {

    private AddSongFragmentBinding binding;
    private SongsViewModel songsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = AddSongFragmentBinding.inflate(inflater, container, false);
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