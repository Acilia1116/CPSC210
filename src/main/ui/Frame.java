package ui;

import model.Event;
import model.EventLog;
import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// EFFECTS: class that represents GUI
public class Frame extends JFrame implements ActionListener {
    private JTextField titleField;
    private JTextField artistField;
    private JPanel buttonPane;
    private JPanel fieldsPanel;
    private JLabel title;
    private JLabel artist;
    private JButton addButton;
    private JButton viewButton;
    private JButton reloadButton;
    private JButton saveButton;
    private JButton deleteButton;
    private String storeTitle = "";
    private String storeArtist = "";
    private Playlist playlist;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/MusicPlayer.json";
    private JFrame frame2;

    // private JTextArea logArea;

    // private JTextField title;


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public Frame() {
        //
        super("Playlist");
//        setSize(600, 400);
//        setVisible(true);
//        setLocationRelativeTo(null);

        // display image in the frame
        ImageIcon bg = new ImageIcon("src/img.jpg");
        JLabel label = new JLabel(bg);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
        Container contain = this.getContentPane();
        ((JPanel) contain).setOpaque(false);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        //

        addButton = new JButton("AddSong");
        viewButton = new JButton("ViewSong");
        reloadButton = new JButton("Reload");
        saveButton = new JButton("Save");
        deleteButton = new JButton("Delete Song");


        add(addButton);
        add(viewButton);
        add(reloadButton);
        add(saveButton);
        add(deleteButton);


        pack();
        //  setLayout(new GridLayout(2, 4));
        setLayout(new FlowLayout());
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);

       // logArea = new JTextArea();

        //setLayout(new GridLayout(2, 4));


        // EFFECTS: click button to add songs
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSong();
            }
        });

        // EFFECT: click button to view added song
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPlaylist();
            }
        });

        // EFFECTS: click button to save and quit
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePlaylist();
            }
        });

        // EFFECTS: click button to reload the information
        reloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPlaylist();
            }
        });

        // EFFECTS: click button to delete song
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSong();
            }
        });


        playlist = new Playlist("hi", "hi");


        buttonPane = new JPanel();
        fieldsPanel = new JPanel();
        title = new JLabel("Enter Song Title");
        artist = new JLabel("Enter Song Artist");
        titleField = new JTextField("");
        artistField = new JTextField("");

        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        buttonPane.setLayout(new FlowLayout());

        fieldsPanel.add(title);
        fieldsPanel.add(artist);
        fieldsPanel.add(titleField);
        fieldsPanel.add(artistField);
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        buttonPane.add(ok);
        buttonPane.add(cancel);
//
//        frame = new JFrame("Player");
//        frame.add(fieldsPanel, BorderLayout.PAGE_START);
//        frame.add(buttonPane, BorderLayout.PAGE_END);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);


//        title = new JTextField();
//        add(title);
//        enterName = new JLabel("Enter Song Title:");
//        add(enterName);

// SET IMAGE HERE LATER!!
//        ImageIcon bg = new ImageIcon("src/tobs.jpg");
//        JPanel panel1 = new JPanel();
//        panel1.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
//        panel1.setLayout(null);
//        background = new JLabel(bg);
//        background.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
//        panel1.add(background);
//        add(panel1);

        //this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));

        // panel1.setOpaque(false);

        addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
//            storeTitle = titleField.getText();
//            JOptionPane.showInputDialog(null, "Title" + storeTitle);
//            storeArtist = artistField.getText();
//            JOptionPane.showInputDialog(null, "Artist" + storeArtist);

        }

    }

    // EFFECTS: add a song to the playlist with  title and song artist name
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:SuppressWarnings"})
    public void addSong() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Artist: "));
        JTextField artistField = new JTextField(20);
        panel.add(artistField);
        panel.add(new JLabel("Enter Title: "));
        JTextField titleField = new JTextField(20);
        panel.add(titleField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Enter", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Song newSong = new Song(null, null);
            newSong.setArtist(artistField.getText());
            newSong.setTitle(titleField.getText());
            playlist.addSong(newSong);

        }
    }

    // EFFECTS: show all songs in the playlist
    public void viewPlaylist() {
//        JPanel panel2 = new JPanel();
//        panel2.add(new JLabel("Added Songs :"));
//        JTextField viewField = new JTextField(10);
//        panel2.add(viewField);

        if (playlist.getPlaylistSize() == 0) {
            //   System.out.println("\nPlaylist empty!");
            JOptionPane.showMessageDialog(null, "Playlist Empty!");

        } else {
            String str = "";
            for (int i = 0; i < playlist.getPlaylistSize(); i++) {
                str += "\n" + (i + 1) + " ";
                str += "" + "Artist" + ": " + playlist.getArtist(i) + " - ";
                str += "\"" + "Title" + ": " + playlist.getTitle(i) + "\"" + ", ";
            }
            //  System.out.println("\n");
            JOptionPane.showMessageDialog(null, str);
        }
    }

    // EFFECTS: save and quit the project, print logged events.
    private void savePlaylist() {
        try {
            jsonWriter.open();
            jsonWriter.write(playlist);
            jsonWriter.close();
            System.out.println("Saved " + playlist.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        getEventDescription(EventLog.getInstance());
        // System.out.print(EventLog.getInstance());
        System.exit(0);
    }

    // EFFECTS: reload the information
    private void loadPlaylist() {
        try {
            playlist = jsonReader.read();
            System.out.println("Loaded " + playlist.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    // EFFECTS: remove the song from the playlist, print message "Playlist Empty!" if the playlist is empty.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void removeSong() {
        frame2 = new JFrame("Remove");
        JPanel panel2 = new JPanel();
        JButton ok = new JButton("OK");
        JTextField field = new JTextField(20);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeSelection = Integer.parseInt(field.getText());


                if (removeSelection > playlist.getPlaylistSize() || removeSelection <= 0) {
                    //System.out.println("This is not an invalid select\n");
                    JOptionPane.showMessageDialog(null, "This is not an invalid select");
                } else {
                    playlist.removeSong(removeSelection - 1);
                    //  stopRemove = true;
                }
                frame2.dispose();
            }
        });
        panel2.add(new JLabel("Please select a song to remove: "));
        panel2.add(field);
        panel2.add(ok);
        frame2.add(panel2);

        if (playlist.getPlaylistSize() == 0) {
            //System.out.println("\nPlaylist empty!");
            JOptionPane.showMessageDialog(null, "Playlist Empty!");
        } else {
            //viewPlaylist();

            frame2.pack();
            frame2.setVisible(true);
//            boolean stopRemove = false;
//            do {
//                System.out.println("\nPlease select a song to remove");
//
//            } while (stopRemove == false);

        }
    }

    // EFFECTS: get description and date of logged events
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:SuppressWarnings"})
    private String getEventDescription(EventLog el) {
        for (Event next : el) {
            System.out.println(next.toString());
        }
        return null;
    }
}






