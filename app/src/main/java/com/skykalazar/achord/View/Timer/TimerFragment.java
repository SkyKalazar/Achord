package com.skykalazar.achord.View.Timer;



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

import com.skykalazar.achord.ViewModel.Songs.SongsViewModel;
import com.skykalazar.achord.databinding.TimerFragmentBinding;



public class TimerFragment extends Fragment {

    private TimerFragmentBinding binding;
    private SongsViewModel songsViewModel;
    private Chronometer timer;
    private boolean running;
    private long pauseOffset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);
        binding = TimerFragmentBinding.inflate(inflater, container, false);

        timer = binding.SongTimer;


        return binding.getRoot();
    }
    public void startTimer(View v) {
        if(!running) {
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
            running = true;
        }
    }
    public void pauseTimer(View v) {
        if(running) {
            timer.stop();
            running = false;
        }
    }
    public void resetTimer(View v) {

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);
        binding.StartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer(view);
            }
        });
        binding.PauseTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseTimer(view);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}