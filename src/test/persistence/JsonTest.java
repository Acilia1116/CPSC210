package persistence;

import model.Song;
import model.Playlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkSongs(String title, String artist, Song song){
        assertEquals(title,song.getTitle());
        assertEquals(artist,song.getArtist());
    }


}
