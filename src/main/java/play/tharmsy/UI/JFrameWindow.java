package play.tharmsy.UI;

import javax.swing.*;
import java.awt.*;
import play.tharmsy.utlits.Render;
import play.tharmsy.utlits.RoundedText;

public class JFrameWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Example");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        RoundedText roundedInputField = (RoundedText) Render.RoundedInput(50, 150, 150, 30, 99999, new Font("Arial", Font.PLAIN, 16), Color.BLACK, Color.WHITE);
        frame.add(roundedInputField);

        RoundedText roundedOutlinedInputField = (RoundedText) Render.RoundedOutlinedInput(50, 200, 150, 30, 12, new Font("Arial", Font.PLAIN, 16), Color.BLACK, Color.WHITE, Color.BLUE, 2.0f);
        frame.add(roundedOutlinedInputField);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
