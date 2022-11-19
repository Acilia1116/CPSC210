package ui;

import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Music Player Application
public class MusicPlayerApp {
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/MusicPlayer.json";
    private Scanner scan = new Scanner(System.in);
    private Playlist playlist = new Playlist("V", "hiphop");


    // EFFECTS: construct a music player and run this application
    public MusicPlayerApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        // loadPlaylist();
        runPlayer();
    }

    //EFFECTS: represents a menu with what you can do
    public int menu() {
        int selection;
        System.out.println("\n what do you like to do? "
                + "\n1- Add Song"
                + "\n2- Play Song"
                + "\n3- Remove Song"
                + "\n4- Delete Playlist"
                + "\n5- Update Song"
                + "\n6- Update Playlist"
                + "\n7- Save Playlist"
                + "\n8- Load playlist"
                + "\nSelection: ");

        selection = scan.nextInt();
        System.out.println("\n");
        return selection;
    }

    // EFFECTS: choose your next step
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void runPlayer() {
        int selection = menu();
        switch (selection) {
            case 1:
                addSong();
                savePlaylist();
                runPlayer();
                break;
            case 2:
                playSong();
                runPlayer();
                break;
            case 3:
                removeSong();
                savePlaylist();
                runPlayer();
                break;
            case 4:
                playlist.removeAll();
                runPlayer();
                break;
            case 5:
                updateSong();
                runPlayer();
                break;
            case 6:
                updatePlaylist();
                runPlayer();
                break;
            case 7:
                savePlaylist();
                System.exit(0);
                break;
            case 8:
                loadPlaylist();
                runPlayer();
                break;
            default:
                System.out.println("\nThat is not an valid selection");
                runPlayer();
        }
    }

    // EFFECTS: do add song
    public void addSong() {
        Song newSong = new Song(null, null);
        newSong.setArtist(scan.nextLine());
        System.out.println("Enter Artist: ");
        newSong.setArtist(scan.nextLine());
        System.out.println("Enter Title: ");
        newSong.setTitle(scan.nextLine());
        playlist.addSong(newSong);
    }

    // EFFECTS: do view playlist
    public void viewPlaylist() {
        if (playlist.getPlaylistSize() == 0) {
            System.out.println("\nPlaylist empty!");
        } else {
            for (int i = 0; i < playlist.getPlaylistSize(); i++) {
                System.out.print("\n" + (i + 1) + " ");
                System.out.print("" + "Artist" + ": " + playlist.getArtist(i) + " - ");
                System.out.print("\"" + "Title" + ": " + playlist.getTitle(i) + "\"" + ", ");
            }
            System.out.println("\n");
        }
    }

    // EFFECTS: do remove song
    public void removeSong() {
        if (playlist.getPlaylistSize() == 0) {
            System.out.println("\nPlaylist empty!");
        } else {
            viewPlaylist();
            boolean stopRemove = false;
            do {
                System.out.println("\nPlease select a song to remove");
                int removeSelection = scan.nextInt();
                if (removeSelection > playlist.getPlaylistSize() || removeSelection <= 0) {
                    System.out.println("This is not an invalid select\n");
                } else {
                    playlist.removeSong(removeSelection - 1);
                    stopRemove = true;
                }
            } while (stopRemove == false);
        }
    }


    // EFFECTS: do update playlist (change playlist description or change playlist name)
    public void updatePlaylist() {
        System.out.println("\n what would you like to update?\n"
                + "1- Playlist Name\n"
                + "2- Playlist Description\n"
                + "Selection:");
        int updateSelection = scan.nextInt();
        switch (updateSelection) {
            case 1:
                System.out.println("Enter playlist name: ");
                String name = scan.next();
                playlist.setName(name);
                break;
            case 2:
                System.out.println("Enter playlist description: ");
                String description = scan.next();
                playlist.setDescription(description);
                break;
            default:
                System.out.println("\nThat is not a valid selection");
        }
    }

    // EFFECTS: do update song in playlist (change song title or change song artist)
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void updateSong() {
        if (playlist.getPlaylistSize() == 0) {
            System.out.println("\nPlaylist Empty");
        } else {
            viewPlaylist();
            System.out.println("\nPlease select a song to update: ");
            int songSelection = scan.nextInt();
            System.out.println("\nWhat would you like to update\n"
                    + "1-Artist\n"
                    + "2-Title\n"
                    + "Selection: ");
            int updateSelection = scan.nextInt();
            switch (updateSelection) {
                case 1:
                    System.out.println("\nEnter Artist: ");
                    String artist = scan.next();
                    playlist.updateArtist(songSelection, artist);
                    break;
                case 2:
                    System.out.println("\nEnter Title: ");
                    String title = scan.next();
                    playlist.updateTitle(songSelection, title);
                    break;
                default:
                    System.out.println("\nThat is a not valid selection");
                    runPlayer();
            }
        }
    }

    //  EFFECTS: write the contents of Playlist to a file called playlist.
//    public void savePlaylist() {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("playlist");
//
//            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);
//
//            outObjectStream.writeObject(playlist);
//
//            outObjectStream.flush();
//            outObjectStream.close();
//        } catch (FileNotFoundException fnfException) {
//            System.out.println("No file");
//        } catch (IOException ioException) {
//            System.out.println("bad IO");
//        }
//    }


    // EFFECTS: search songs to play
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void playSong() {
        if (playlist.getPlaylistSize() == 0) {
            System.out.println("\nPlaylist Empty");
        } else {
            viewPlaylist();
            System.out.println("\nPlease select a song to play: "
                    + "\n select by name"
                    + "\n select by artist");
            int selectionMode = scan.nextInt();
            switch (selectionMode) {
                case 1:
                    System.out.println("\nEnter Name: ");
                    String name = scan.next();
                    playlist.searchSongByName(name);
                    break;
                case 2:
                    System.out.println("\nEnter Artist: ");
                    String artist = scan.next();
                    playlist.searchSongByArtist(artist);
                    break;
                default:
                    System.out.println("\nThat is a not valid selection");
                    runPlayer();
            }
        }
    }


    // EFFECTS: Reads the file contents containing to a playlist.
//    public void loadPlaylist() {
//        try {
//            FileInputStream fileInputStream = new FileInputStream("playlist");
//
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//            playlist = (Playlist) objectInputStream.readObject();
//
//            objectInputStream.close();
//        } catch (FileNotFoundException fnfException) {
//            System.out.println("No File");
//        } catch (IOException ioException) {
//            System.out.println("IO no good");
//        } catch (ClassNotFoundException cnfException) {
//            System.out.println("This is not a Playlist.");
//        }
//    }


    // EFFECTS: saves the workroom to file
    private void savePlaylist() {
        try {
            jsonWriter.open();
            jsonWriter.write(playlist);
            jsonWriter.close();
            System.out.println("Saved " + playlist.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads playlist from file
    private void loadPlaylist() {
        try {
            playlist = jsonReader.read();
            System.out.println("Loaded " + playlist.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}