package persistence;

import model.Playlist;
import model.Song;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            Playlist playlist = new Playlist("My Playlist", "Description");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Playlist playlist = new Playlist("My Playlist", "Description");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlayer.json");
            writer.open();
            writer.write(playlist);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlayer.json");
            playlist = reader.read();
            assertEquals("My Playlist", playlist.getName());
            assertEquals("Description", playlist.getDescription());
            assertEquals(0, playlist.getPlaylistSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testGeneralPlayer() {
        try {
            Playlist playlist = new Playlist("My Playlist", "My Favourite Songs");
            playlist.addSong(new Song("Highway to Hell", "AC/DC"));
            playlist.addSong(new Song("Back In Black", "AC/DC"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlayer.json");
            writer.open();
            writer.write(playlist);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterGeneralPlayer.json");
            playlist = reader.read();
            assertEquals("My Playlist",playlist.getName());
            ArrayList<Song> songs = playlist.getSongs();
            assertEquals(2, songs.size());
            checkSongs("Highway to Hell","AC/DC",songs.get(0));
            checkSongs("Back In Black","AC/DC",songs.get(1));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
