package com.skykalazar.achord.UI.Songs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.skykalazar.achord.databinding.FragmentSongsBinding;


public class SongsFragment extends Fragment {

    private FragmentSongsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SongsViewModel songsViewModel =
                new ViewModelProvider(this).get(SongsViewModel.class);

        binding = FragmentSongsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView songs = binding.rv1;
        songsViewModel.getSongs().observe(getViewLifecycleOwner(), new Observer<RecyclerView>() {
            @Override
            public void onChanged(RecyclerView recyclerView) {
                songs = recyclerView;
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}