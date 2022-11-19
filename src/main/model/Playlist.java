package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;


public class Playlist implements Writable {
    // this class represents lists of songs, with playlist name and description
    private String name;
    private String description;
    private final ArrayList<Song> playlist;

    // EFFECT: construct a playlist object with playlist name, playlist description and  songs
    public Playlist(String name, String description) {
        this.description = description;
        this.name = name;
        playlist = new ArrayList<>();
    }

    public void setName(String s) {
        name = s;
    }

    public void setDescription(String s) {
        description = s;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // MODIFIES: this
    // EFFECTS: add a new song to this playlist
    public void addSong(Song song) {
        playlist.add(song);
        EventLog.getInstance().logEvent(new Event("A song has added to the playlist"
                + "\nTitle: " + song.getTitle()
                + "\nArtist: " + song.getArtist()));
    }

    // EFFECTS: return playlist size
    public int getPlaylistSize() {
        return playlist.size();
    }


    // EFFECTS: return song artist in playlist with given index(represent song position in playlist)
    public String getArtist(int index) {
        return playlist.get(index).getArtist();
    }

    // EFFECTS: return song title in playlist with given index(represent song position in playlist)
    public String getTitle(int index) {
        return playlist.get(index).getTitle();
    }

    // EFFECTS: return all songs from the playlist
    public ArrayList<Song> getSongs() {
        return playlist;
    }

    // MODIFIES: this
    // EFFECTS: remove a song located at specific index and return true, return false if playlist is empty
    public boolean removeSong(int index) {
        if (playlist.size() == 0) {
            return false;
        } else {
            playlist.remove(index);
            EventLog.getInstance().logEvent(new Event("A song has deleted from the playlist"));
            return true;
        }
    }

    //EFFECTS: sets the artist of the Song at position (index) to artist.
    public void updateArtist(int index, String artist) {
        playlist.get(index).setArtist(artist);
    }

    // EFFECTS: sets the title of the Song at position (index) to the title.
    public void updateTitle(int index, String title) {
        playlist.get(index).setTitle(title);
    }

    // MODIFIES: this
    // EFFECTS: remove all songs from this playlist
    public void removeAll() {
        if (playlist.size() == 0) {
           // System.out.print("Playlist is empty!\n");
        } else {
            playlist.clear();
        }
    }


    // EFFECTS: return a list of songs of given artist
    public ArrayList<Song> searchSongByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s : playlist) {
            if (s.getArtist() == artist) {
                result.add(s);
            }
        }
        return result;
    }

    // EFFECTS: return a list of songs of given name
    public ArrayList<Song> searchSongByName(String name) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s : playlist) {
            if (s.getTitle() == name) {
                result.add(s);
            }
        }
        return result;
    }

    // EFFECTS: return Json Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("description", description);
        json.put("songs", songsToJson());
        return json;
    }

    // EFFECTS: return Json Array
    private JSONArray songsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Song s : playlist) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }
}
