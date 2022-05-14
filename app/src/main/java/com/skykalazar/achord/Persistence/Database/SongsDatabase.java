package com.skykalazar.achord.Persistence.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.skykalazar.achord.Model.Song;
import com.skykalazar.achord.Persistence.DAO.SongsDAO;

@Database(entities = {Song.class}, version = 6)
public abstract class SongsDatabase extends RoomDatabase {

    private static SongsDatabase instance;

    public static synchronized  SongsDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, SongsDatabase.class,
                    "songs_database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract SongsDAO getSongDAO();

}
