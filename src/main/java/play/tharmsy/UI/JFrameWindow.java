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

                Render.drawGradientRoundedSquare(g, 150, 50, 100, 20, 20, Color.BLUE, Color.GREEN);
                Render.drawRoundedSquare(g, 150, 200, 100, 20, 20, 255, 0, 0);
                Render.drawOutlineSquare(g, 150, 350, 100, 255, 0, 0, 5.0f, 20, 20);
                Render.drawRoundedButton(g, 150, 500, 100, 50, 20, 20, 255, 0, 0, "Button", Color.WHITE);
                Render.drawShadowedRoundedSquare(g, 150, 650, 100, 20, 20, 255, 0, 0, 10, 0, 0, 0);

            }

        };

        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
