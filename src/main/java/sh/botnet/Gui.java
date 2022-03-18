package sh.botnet;

import javax.swing.*;
import java.awt.image.BufferedImage;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.*;

public class Gui implements Runnable {
    // Sloppy but who cares
    private JLabel label = new JLabel();
    // TODO: Change this, move Rect to globals file or something similar since Swing requires some nonsense with imageicons on startup..
    private ImageIcon imageIcon = new ImageIcon(SRobot.getRobot().createScreenCapture(new Rectangle(0, 0, 5120, 1440)));
    private JTextField fpsField = new JTextField();
    // This shouldn't be in the UI class for obvious reasons
    // Problem with that: I don't want to bother encapsulating it elsewhere and then wiring 
    // threads together properly for a meme project that's < 150 lines.
    private boolean isCapturing;

    public Gui() {
        this.isCapturing = true;
    }

    public void setNewMapFrame(BufferedImage minimapCapture) {
        imageIcon = new ImageIcon(minimapCapture);
        // imageIcon.setImage(minimapCapture);
        this.label.setIcon(imageIcon);
    } 

    public boolean shouldCapture() {
        return this.isCapturing;
    }

    private void setupFlatlaf() {
        FlatDarculaLaf.setup();
    }

    @Override
    public void run()
    {
        this.setupFlatlaf();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton applyButton = new JButton("Apply");
        JButton capButton = new JButton("Capture");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        // TODO: Find better layout... Flow maybe?
        panel.setLayout(new BorderLayout());
        // panel.add(capButton);
        panel.add(applyButton);
        panel.add(label, BorderLayout.PAGE_END);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("League Meme - github.com/zkxjzmswkwl/league-map-inator");
        frame.setSize(500, 600);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
}
