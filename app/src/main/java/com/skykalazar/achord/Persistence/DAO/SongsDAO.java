package com.skykalazar.achord.Persistence.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.skykalazar.achord.Model.Song;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface SongsDAO {

    @Insert
    void insert(Song newSong);

    @Query("select * from songs_table order by id")
    LiveData<List<Song>> getAllSongs();


}
