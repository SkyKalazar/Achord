package com.skykalazar.achord.Persistence.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.skykalazar.achord.Model.Song;

import java.util.List;

@Dao
public interface SongsDAO {

    @Insert
    void insert(Song newSong);

    @Update
    void update(Song song);

    @Delete
    void delete(Song song);

    @Query("select * from songs_table order by id")
    LiveData<List<Song>> getAllSongs();

    @Query("delete from songs_table")
    void nukeTable();


}
