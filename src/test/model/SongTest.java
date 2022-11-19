package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SongTest {
    private Song testSong1;
    private Song testSong2;
    private Song testSong3;
    private Song testSong4;
    final String title1 = "Ghetto Artist";
    final String title2 = "Lucy Liu";
    final String title3 = "Midsummer Madness";
    final String title4 = "La La Lost You";
    final String artist1 = "HigherBrother";
    final String artist2 = "88rising";
    final String defaultArtist = "unknown";


    @BeforeEach
    void runBefore(){
        testSong1 = new Song(title1,artist1);
        testSong2 = new Song(title2,null);
        testSong3 = new Song(title2,artist2);
        testSong4 = new Song(title2,artist1);
    }

    @Test
    public void testConstructor(){
        assertNotNull(testSong1);
        assertNotNull(testSong2);
        assertNotNull(testSong3);
        assertNotNull(testSong4);
    }
    @Test
    public void testGetters(){
        assertEquals(title1, testSong1.getTitle());
        assertEquals(title2, testSong2.getTitle());
        assertEquals(title2, testSong3.getTitle());
        assertEquals(title2, testSong4.getTitle());

        assertEquals(artist1,testSong1.getArtist());
        assertEquals(defaultArtist,testSong2.getArtist());
        assertEquals(artist2,testSong3.getArtist());
        assertEquals(artist1,testSong4.getArtist());
    }

    @Test
    public void testSetters(){
        testSong1.setTitle(title3);
        testSong1.setArtist(artist2);
        assertEquals(title3,testSong1.getTitle());
        assertEquals(artist2,testSong1.getArtist());

        testSong1.setArtist(defaultArtist);
        testSong2.setArtist(artist2);
        assertEquals(defaultArtist,testSong1.getArtist());
        assertEquals(artist2,testSong2.getArtist());
    }
}
