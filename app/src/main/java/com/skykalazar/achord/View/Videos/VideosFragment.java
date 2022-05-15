package com.skykalazar.achord.View.Videos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.skykalazar.achord.ViewModel.VideosViewModel;
import com.skykalazar.achord.databinding.VideosFragmentBinding;

public class VideosFragment extends Fragment {

    private VideosFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VideosViewModel videosViewModel =
                new ViewModelProvider(this).get(VideosViewModel.class);

        binding = VideosFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        videosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}