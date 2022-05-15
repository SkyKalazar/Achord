package com.skykalazar.achord.View.Timer;



import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.skykalazar.achord.R;
import com.skykalazar.achord.ViewModel.SongsViewModel;
import com.skykalazar.achord.databinding.TimerFragmentBinding;



public class TimerFragment extends Fragment {

    private TimerFragmentBinding binding;
    private SongsViewModel songsViewModel;
    private Chronometer timer;
    private boolean running;
    private long elapsedTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        songsViewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);
        binding = TimerFragmentBinding.inflate(inflater, container, false);

        timer = binding.SongTimer;


        return binding.getRoot();
    }
    public void startTimer(View v) {
        if(!running) {
            timer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
            timer.start();
            running = true;
        }
    }
    public void pauseTimer(View v) {
        if(running) {
            timer.stop();
            elapsedTime = SystemClock.elapsedRealtime() - timer.getBase();
            running = false;
        }
    }
    public void resetTimer(View v) {
        timer.setBase(SystemClock.elapsedRealtime());
        elapsedTime = 0;
        timer.stop();
        running = false;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);
        binding.StartTimer.setOnClickListener(this::startTimer);
        binding.PauseTimer.setOnClickListener(this::pauseTimer);
        binding.ResetTimer.setOnClickListener(this::resetTimer);
        binding.SaveTimer.setOnClickListener(view1 -> {
            songsViewModel.incrementTimer(elapsedTime);
            resetTimer(view1);
            NavHostFragment.findNavController(TimerFragment.this).navigate(R.id.action_from_timer_to_details);
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        songsViewModel.setTimerBase(timer.getBase());
    }
    @Override
    public void onResume() {
        super.onResume();
        elapsedTime = SystemClock.elapsedRealtime() - songsViewModel.getTimerBase();
        startTimer(getView());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}