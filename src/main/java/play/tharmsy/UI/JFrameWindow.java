package play.tharmsy.UI;

import javax.swing.*;
import java.awt.*;
import play.tharmsy.utlits.Render;

public class JFrameWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Everything");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                Render.drawImageWithOutline(g, "Cute-Pug", 10, 10, 100, 100, Color.BLUE, 2.0f);
                Render.drawRoundedSquare(g, 10, 120, 100, 10, 10, 255, 0, 0);
                Render.drawOutlineSquare(g, 10, 230, 100, 255, 0, 0, 2.0f, 10, 10);
                Render.drawGradientRoundedSquare(g, 10, 340, 100, 10, 10, Color.RED, Color.BLUE);
                Render.drawRoundedButton(g, 10, 450, 100, 100, 10, 10, 255, 0, 0, "Button", Color.WHITE);

            }
        };


        JButton refreshButton = new JButton("ReRender");
        refreshButton.addActionListener(e -> panel.repaint());


        frame.getContentPane().add(refreshButton, BorderLayout.SOUTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
