package com.skykalazar.achord.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.Persistence.DAO.SongsDAO;
import com.skykalazar.achord.Persistence.Database.SongsDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SongsRepository {

    private static SongsRepository instance;
    private final SongsDAO songsDAO;
    private final LiveData<List<Song>> songs;
    private final ExecutorService executorService;

    private SongsRepository(Application app) {

        executorService = Executors.newFixedThreadPool(2);
        SongsDatabase database = SongsDatabase.getInstance(app);
        songsDAO = database.getSongDAO();
        songs = songsDAO.getAllSongs();

    }

    public static synchronized SongsRepository getInstance(Application app) {
        if(instance == null)
            instance = new SongsRepository(app);

        return instance;
    }

    public LiveData<List<Song>> getAllSongs() {
        return songs;

    }
    public void insert(Song newSong) {
        executorService.execute(() -> songsDAO.insert(newSong));
    }

    private void deleteAllSongs() {
        executorService.execute(songsDAO::nukeTable);
    }
}
