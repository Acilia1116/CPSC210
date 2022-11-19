package ui;

import javax.swing.*;
import java.io.FileNotFoundException;


// main class, run this project
public class Main extends JFrame {
    public static void main(String[] args) {
        new Frame();
//        JFrame frame = new JFrame("test");
//        frame.setSize(400,400);
//        frame.setVisible(true);
//        frame. setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JButton button1 = new JButton("addSong");
//        JButton button2 = new JButton("viewSong");
//        JButton button3 = new JButton("reload");
//        JButton button4 = new JButton("save");
//
//        frame.setLayout(new GridLayout(2,2));
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);
//        frame.add(button4);
//
//        frame.pack();

        try {
            new MusicPlayerApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

}
