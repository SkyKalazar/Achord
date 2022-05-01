package com.skykalazar.achord.ViewModel.Songs;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.Repositories.SongsRepository;

import java.util.List;

public class SongsViewModel extends AndroidViewModel {

    private final SongsRepository repository;
    private MutableLiveData<Song> currentSong;

    public SongsViewModel(Application app) {
        super(app);
        repository = SongsRepository.getInstance(app);
        currentSong = new MutableLiveData<>();

    }

    public LiveData<List<Song>> getSongs() {
        return repository.getAllSongs();
    }

    public void addSong(Song newSong) {
       repository.insert(newSong);
    }
    public void updateSong() {
        repository.update(currentSong.getValue());
    }

    public LiveData<Song> getCurrentSong() {
        return currentSong;
    }
    public void setCurrentSong(Song currentSong) {
        this.currentSong.setValue(currentSong);
    }
}