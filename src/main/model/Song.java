package model;

import org.json.JSONObject;
import persistence.Writable;

public class Song implements Writable {
    // this class represents each single songs with song names, artists, and files;
    private String artist;
    private String title;
    private final String defaultArtist = "unknown";

    // EFFECTS: construct a song object with title and artist
    public Song(String title, String artist) {
        this.title = title;
        if (artist == null) {
            this.artist = defaultArtist;
        } else {
            this.artist = artist;
        }
    }

    // EFFECTS: sets song's title to the given title.
    public void setTitle(String title) {
        this.title = title;
    }

    // EFFECTS: sets song's artist to the given artist.
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // EFFECT: get title of song
    public String getTitle() {
        return title;
    }

    // EFFECT: get artist of song
    public String getArtist() {
        return artist;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("artist", artist);
        json.put("title", title);
        return json;
    }
}
