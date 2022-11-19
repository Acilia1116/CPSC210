# My Personal Project: 

## Music Player Application

### What will the application do:

- This is a customized music player, this application will be similar to application like Spotify,
Apple Music and YouTube Music. 

- It will allow you to create your own music playlists and modes.


- **Songs:** 
You can upload your local audio files. Each song has names and artists.

- **Playlists:** 
There is a master playlist that includes all the songs imported by the user. 
Each playlist may contain sub-playlists.  
A playlists may contain songs, views and  number of songs. 
A playlist may also be sorted by artists or song titles.

- **Play Modes:** 
- Regular / Shuffle / Repeat
- Next / Previous / Stop

### Why is this project of interest you?
Nowadays, there are various music player applications on app stores, but few of them support uploading local audio files.
Moreover, due to the platform restriction, copyright and other reasons, 
I cannot find all my favourite songs in one single application, 
which means I have to download several music players applications,
and switch applications constantly. Let alone the  annoying ads and membership fees

### Who will use it:
This application is for people who want  to upload and arrange their local music in an orderly manner, 
want to play songs in your preferred modes with ads-free. 
Download this music player application and immerse yourself totally
in musics.

## User Stories:
- As a user, I want to be able to specify a path/directory and import all the audio files from it


- As a user, I want to be able to view and play all songs (phase 1)


- As a user, I want to be able to create a playlist, with its name and description (phase 1)


- As a user, I want to be able to save the playlist I create (phase 1)


- As a user, I want to be able to edit the name and description of the playlist (phase 1)


- As a user, I want to be able to create a list of  recently played songs (last week and whole time)


- As a user, I want to be able to create a list of most viewed songs 


- As  a user, I want to be able to create a list of my favourite songs


- As a user, I want to be able to delete a playlist (phase 1)


- As a user, I want to be able to add a song into my playlist (phase 1)


- As a user, I want to be able to delete songs from my playlist (phase 1)


- As a user, I want to be able to search songs through song names or artists (phase 1 )


- As a user, I want to be able to search playlist through playlists’ name, or any songs of playlists (phase 1)


- As a user, I want to be able to play a song, regular / repeat / shuffle / stop / previous / next


- As a user, I want to be able to play a playlist, regular / repeat


- As a user, when I open my music player, I want to be given the *option* to load my playlist from file, 
    exactly as the same state I quit last time. (phase 2)

  
- As a user, I want to be able to save the changes I made to the songs and the playlists (phase 2)


## Instructions for grader:
- You can generate the first required event by click the **Add Song** button.
There will exist a pop-up window after you click this button, you could enter song title and song artist here,
Then lick **OK** button or **Enter Key** to add this song to the playlist.
To see added songs, you could click the **View Song** button;


- You can generate the second required event by click the **Delete Song** button.
There will exist a pop-up window after you click this button, you could enter the index of song in this playlist.
Then click **OK** button to delete this song from the playlist.
To check delete successfully, you could click the **View Song** button;


- You can save the state of my application by click the **Save** button; 
You will automatically quit after you click **Save** button;


- You can reload the state of my application by click the **Reload** button;
To see reloaded information, you could click **View Song** button;


- The **visual component** is added as background image/ wall paper; it will display
when user run this project;


## Phase 4: Task 2:
- **printed event**:
- Thu Aug 11 13:46:15 PDT 2022
  A song has added to the playlist 
  Title: 1
  Artist: 1
  Thu Aug 11 13:46:18 PDT 2022
  A song has deleted from the playlist

  (add one song into the playlist then delete it )

- Thu Aug 11 13:49:52 PDT 2022
  A song has added to the playlist
  Title: 1
  Artist: 1
  Thu Aug 11 13:49:56 PDT 2022
  A song has added to the playlist
  Title: 2
  Artist: 2

  (add two songs into the playlist)


## Phase 4: Task 3:
- The DML class diagram is not well-organized. Classes in model package, Song class, Playlist class, Event class and
EventLog class, looks organized. Playlist use the Song object in its field and both the Song and Playlist classes implement
Writable interface. Playlist class, Song class and Writable interface should be a cluster, since they represent a music playlist.


- EventLog use Event object in its field. While the relationship in other classes from ui and persistence
packages seems more complicated and the UML diagram looks less organized. That's might because both Frame class and MusicPlayerApp
class use JsonReader, JsonWriter and Playlist objects in their fields. 


- MusicPlayerApp class represents all functions of playlist, and the Frame class represents actually implementing functions of playlist 
when clicking button, through calling method from MusicPlayerApp class. These two class together represents implementing
functions of playlist, these two classes looks like a cluster. While These two classes have lots of duplicated method, 
to improve the and improve coupling, I could abstract duplicated codes into methods, add an abstract class then let 
Frame class and MusicPlayerApp to extends this class.





  