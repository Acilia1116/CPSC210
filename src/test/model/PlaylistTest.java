package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    // filed
    private Song testSong1;
    private Song testSong2;
    private Song testSong3;
    private Song testSong4;
    private Song testSong5;
    final String name1 = "song 1";
    final String name2 = "song 2";
    final String name3 = "song 3";
    final String defaultArtist = "unknown";

    final String artist1 = "artist1";
    final String artist2 = "artist2";
    final String artist3 = "artist3";

    Playlist playlist1;
    Playlist playlist2;

    String pName1 = "playlist 1";
    String pName2 = "playlist 2";
    String description1 = "Hip-Hop music";
    String description2 = "Rock music";

    @BeforeEach
    void runBefore(){
        testSong1 = new Song(name1, defaultArtist);
        testSong2 = new Song(name2, artist1);
        testSong3 = new Song(name3, artist2);
        testSong4 = new Song(name3, artist3);
        testSong5 = new Song(name3, defaultArtist);

        playlist1 = new Playlist(pName1, description1);
        playlist2 = new Playlist(pName2, description2);
        playlist2.addSong(testSong1);
        playlist2.addSong(testSong2);
        playlist2.addSong(testSong3);
    }

    @Test
    public void testConstructor(){
        assertNotNull(playlist1);
        assertNotNull(playlist2);
    }

    @Test
    void testNameGettersAndSetters() {
        assertEquals(pName1, playlist1.getName());
        assertEquals(pName2, playlist2.getName());
        playlist1.setName(pName2);
        playlist2.setName(pName1);
        assertEquals(pName1, playlist2.getName());
        assertEquals(pName2, playlist1.getName());

    }
    @Test
    void testDescriptionGetterAndSetter() {
        assertEquals(description1, playlist1.getDescription());
        assertEquals(description2, playlist2.getDescription());
        playlist1.setDescription(description2);
        playlist2.setDescription(description1);
        assertEquals(description1, playlist2.getDescription());
        assertEquals(description2, playlist1.getDescription());
    }

    @Test
    void testAddSong(){
        assertEquals(0,playlist1.getPlaylistSize());
        playlist1.addSong(testSong1);
        assertEquals(1,playlist1.getPlaylistSize());
        assertEquals(testSong1,playlist1.getSongs().get(0));

        playlist1.addSong(testSong2);
        assertEquals(2,playlist1.getPlaylistSize());
        assertEquals(testSong2,playlist1.getSongs().get(1));
    }

    @Test
    void testRemoveSong(){
        assertEquals(0,playlist1.getPlaylistSize());
        assertFalse(playlist1.removeSong(0));
        playlist1.addSong(testSong1);
        playlist1.addSong(testSong2);
        assertEquals(2,playlist1.getPlaylistSize());
        assertTrue(playlist1.removeSong(0));
        assertEquals(1,playlist1.getPlaylistSize());
        assertEquals(testSong2,playlist1.getSongs().get(0));
    }

    @Test
    void testRemoveAll(){
        assertEquals(0,playlist1.getPlaylistSize());
        playlist1.removeAll();
        assertEquals(0,playlist1.getPlaylistSize());
        playlist1.addSong(testSong1);
        playlist1.addSong(testSong2);
        playlist1.removeAll();
        assertEquals(3,playlist2.getPlaylistSize());
        playlist2.removeAll();
        assertEquals(0,playlist1.getPlaylistSize());
        assertEquals(0,playlist2.getPlaylistSize());
    }

    @Test
    void testSearchMethod(){
        assertEquals(0, playlist1.searchSongByArtist(artist1).size());
        assertEquals(0, playlist1.searchSongByName(name1).size());

        assertEquals(1, playlist2.searchSongByArtist(artist1).size());
        assertEquals(1, playlist2.searchSongByName(name1).size());

        playlist2.addSong(testSong4);
        playlist2.addSong(testSong5);
        assertEquals(2, playlist2.searchSongByArtist(defaultArtist).size());
        assertEquals(3, playlist2.searchSongByName(name3).size());

    }

    @Test
    void testUpdate(){
        playlist2.updateTitle(0,name2);
        playlist2.updateArtist(0,artist2);
        assertEquals(name2,playlist2.getTitle(0));
        assertEquals(artist2,playlist2.getArtist(0));
    }

}