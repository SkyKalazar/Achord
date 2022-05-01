package com.skykalazar.achord.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.Persistence.DAO.SongsDAO;
import com.skykalazar.achord.Persistence.Database.SongsDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SongsRepository {

    private static SongsRepository instance;
    private final SongsDAO songsDAO;
    private final LiveData<List<Song>> songs;
    private final ExecutorService executorService;

    private SongsRepository(Application app) {

        SongsDatabase database = SongsDatabase.getInstance(app);
        songsDAO = database.getSongDAO();
        songs = songsDAO.getAllSongs();
        executorService = Executors.newFixedThreadPool(2);

        insert(new Song("Age of Oppression", "Malukah"));
        insert(new Song("Crazy", "Gnarls Barkley"));
        insert(new Song("Девушка из Нагасаки", "Вера Инбер"));

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
}
