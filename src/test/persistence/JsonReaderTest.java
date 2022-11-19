package persistence;

import model.Playlist;
import model.Song;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Playlist playlist = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlayer() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlayer.json");
        try {
            Playlist playlist = reader.read();
            assertEquals("name", playlist.getName());
            assertEquals("description", playlist.getDescription());
            assertEquals(0, playlist.getPlaylistSize());
        } catch (IOException e) {
           // fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPlayer() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPlayer.json");
        try {
            Playlist playlist = reader.read();
            assertEquals("My Playlist",playlist.getName());
            ArrayList<Song> songs = playlist.getSongs();
            assertEquals(2,songs.size());
            checkSongs("Back In Black","AC/DC",songs.get(0));
            checkSongs("Highway to Hell","AC/DC",songs.get(1));
        } catch (IOException e) {
          //  fail("Couldn't read from file");
        }


    }
}
