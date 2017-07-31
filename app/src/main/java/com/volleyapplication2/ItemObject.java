package com.volleyapplication2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by syed on 28/7/17.
 */

public class ItemObject {

    @SerializedName("song_name")
    private String songTitle;
    @SerializedName("song_id")
    private String songYear;
    @SerializedName("artist_name")
    private String songAuthor;

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongYear() {
        return songYear;
    }

    public void setSongYear(String songYear) {
        this.songYear = songYear;
    }

    public String getSongAuthor() {
        return songAuthor;
    }

    public void setSongAuthor(String songAuthor) {
        this.songAuthor = songAuthor;
    }
}
