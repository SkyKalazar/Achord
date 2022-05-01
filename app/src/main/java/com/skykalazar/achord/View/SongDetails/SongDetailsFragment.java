package com.skykalazar.achord.View.SongDetails;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.skykalazar.achord.ViewModel.SongsViewModel;
import com.skykalazar.achord.databinding.SongDetailsFragmentBinding;


public class SongDetailsFragment extends Fragment {

    private SongDetailsFragmentBinding binding;
    private SongsViewModel songsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        binding = SongDetailsFragmentBinding.inflate(inflater, container, false);
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