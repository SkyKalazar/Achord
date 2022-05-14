package com.skykalazar.achord.ViewModel.Songs;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.Repositories.SongsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void deleteSong() {
        repository.delete(currentSong.getValue());
    }
    public List<Song> filterByTitle(String title) {
        List<Song> filteredSongs = new ArrayList<>();
        for(int i = 0; i < getSongs().getValue().size(); i++) {
            if(getSongs().getValue().get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                filteredSongs.add(getSongs().getValue().get(i));
            }
        }
        return filteredSongs;
    }

    public void setCurrentSong(Song currentSong) {
        this.currentSong.setValue(currentSong);
    }

    public String getTitle() {
        return Objects.requireNonNull(currentSong.getValue()).getTitle();
    }
    public void setTitle(String newTitle) {
        Objects.requireNonNull(currentSong.getValue()).setTitle(newTitle);
        updateSong();
    }

    public String getArtist() {
        return Objects.requireNonNull(currentSong.getValue()).getArtist();
    }
    public void setArtist(String newArtist) {
        Objects.requireNonNull(currentSong.getValue()).setArtist(newArtist);
        updateSong();
    }

    public String getLyrics() {
        return Objects.requireNonNull(currentSong.getValue()).getLyrics();
    }
    public void setLyrics(String newLyrics) {
        Objects.requireNonNull(currentSong.getValue()).setLyrics(newLyrics);
        updateSong();
    }

    public long getTimeSpent() {
        return Objects.requireNonNull(currentSong.getValue()).getTimeSpent();
    }
    public void incrementTimer(long time) {
        Objects.requireNonNull(currentSong.getValue()).setTimeSpent(time);
        updateSong();
    }

    public boolean isFavourite() {
        return Objects.requireNonNull(currentSong.getValue()).isFavourite();
    }
    public void setFavourite(boolean current) {
        Objects.requireNonNull(currentSong.getValue()).setFavourite(current);
        updateSong();
    }


}