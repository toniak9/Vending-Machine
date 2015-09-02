/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;
    import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Tonia
 */
public class BackgroundImageApp {
    private JFrame frame;

    private BackgroundImageApp create() {
        frame = createFrame();
        frame.getContentPane().add(createContent());

        return this;
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame(getClass().getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }

    private void show() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Component createContent() {
        final Image image = requestImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (String label : new String[]{"One", "Dois", "Drei", "Quatro", "Peace"}) {
            JButton button = new JButton(label);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(15, 15)));
            panel.add(button);
        }

        panel.setPreferredSize(new Dimension(500, 500));

        return panel;
    }

    private Image requestImage() {
        Image image = null;

        try {
            
            image = ImageIO.read(new File("/Users/Tonia/Desktop/images/VM.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BackgroundImageApp().create().show();
            }
        });
    }
}
    
