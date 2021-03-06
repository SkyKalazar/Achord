package com.skykalazar.achord.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "songs_table")
public class Song {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String artist;
    private String lyrics;
    private long timeSpent;
    private boolean favourite;
    private String remark;
    private String difficulty;

    public Song(String title, String artist, String lyrics) {
        this.title = title;
        this.artist = artist;
        this.lyrics = lyrics;
        timeSpent = 0;
        favourite = false;
        remark = "";
        difficulty = "undefined";
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

    public String getLyrics() {
        return lyrics;
    }
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public long getTimeSpent() {
        return timeSpent;
    }
    public void setTimeSpent(long time) {
        timeSpent += time;
    }

    public boolean isFavourite() {
        return favourite;
    }
    public void setFavourite(boolean current) {
        favourite = current;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}