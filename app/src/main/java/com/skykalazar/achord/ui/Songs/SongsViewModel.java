package com.skykalazar.achord.UI.Songs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skykalazar.achord.Model.Song;

import java.util.ArrayList;

public class SongsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Song>> liveDataSongs;
    private ArrayList<Song> songs;

    public SongsViewModel() {
        liveDataSongs = new MutableLiveData<>();
        songs = new ArrayList<>();

        songs.add(new Song("Age of Oppression", "Malukah"));
        songs.add(new Song("Crazy", "Gnarls Barkley"));
        songs.add(new Song("Девушка из Нагасаки", "Вера Инбер"));

        liveDataSongs.setValue(songs);

    }

    public LiveData<ArrayList<Song>> getSongs() {
        return liveDataSongs;
    }

    public void addSong(Song newSong) {
        songs.add(newSong);
    }
}