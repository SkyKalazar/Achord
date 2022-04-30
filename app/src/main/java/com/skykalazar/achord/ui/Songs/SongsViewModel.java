package com.skykalazar.achord.UI.Songs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skykalazar.achord.Model.Song;

import java.util.ArrayList;

public class SongsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Song>> songs;

    public SongsViewModel() {
        songs = new MutableLiveData<>();

        ArrayList<Song> starter = new ArrayList<>();

        starter.add(new Song("Age of Oppression", "Malukah"));
        starter.add(new Song("Crazy", "Gnarls Barkley"));
        starter.add(new Song("Девушка из Нагасаки", "Вера Инбер"));

        songs.setValue(starter);

    }

    public LiveData<ArrayList<Song>> getSongs() {
        return songs;
    }
}