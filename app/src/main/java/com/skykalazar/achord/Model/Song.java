package com.skykalazar.achord.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "songs_table")
public class Song {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
}