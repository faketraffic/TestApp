package play.tharmsy.UI;

import javax.swing.*;

public class JFrameWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Window");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello, this is a basic window!");
        frame.getContentPane().add(label);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}

