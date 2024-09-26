package main;

import javax.swing.JFrame;
import java.util.List;

public class Window {
    JFrame frame;
    private String name;
    private int width;
    private int height;

    public Window(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public void createWindow() {
        // Create a new JFrame (the window)
        frame = new JFrame(name);

        // Set the size of the window (width x height)
        frame.setSize(width, height);

        // Specify what happens when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}