package play.tharmsy.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import play.tharmsy.utlits.Render;

public class JFrameWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Interactive Elements");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Render.drawRoundedSquare(g, 100, 100, 100, 20, 20, 255, 0, 0, true, e -> System.out.println("Clicked"));
                Render.drawOutlineSquare(g, 250, 100, 100, 0, 255, 0, 5, 20, 20, true, e -> System.out.println("Clicked"));
                Render.drawRoundedButton(g, 400, 100, 100, 50, 20, 20, 0, 0, 255, "Click", Color.WHITE, true, e -> System.out.println("Clicked"));
                Render.drawImageWithOutline(g, "src/main/resources/test/pug.png", 550, 100, 100, 100, Color.BLACK, 5, true, e -> System.out.println("Clicked"));
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Render.checkInteractions(e);
            }
        });

        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
