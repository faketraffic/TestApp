package play.tharmsy.utlits;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;

public class Render {
    private static List<Drawable> drawables = new ArrayList<>();

    public static void drawRoundedSquare(Graphics g, int x, int y, int size, int arcWidth, int arcHeight, int red, int green, int blue, boolean isInteractive, Consumer<MouseEvent> onClick) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.fillRoundRect(x, y, size, size, arcWidth, arcHeight);
        if (isInteractive) {
            drawables.add(new Drawable(x, y, size, size, true, onClick));
        }
    }

    public static void drawOutlineSquare(Graphics g, int x, int y, int size, int red, int green, int blue, float thickness, int arcWidth, int arcHeight, boolean isInteractive, Consumer<MouseEvent> onClick) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRoundRect(x, y, size, size, arcWidth, arcHeight);
        if (isInteractive) {
            drawables.add(new Drawable(x, y, size, size, true, onClick));
        }
    }

    public static void drawRoundedButton(Graphics g, int x, int y, int width, int height, int arcWidth, int arcHeight, int red, int green, int blue, String text, Color textColor, boolean isInteractive, Consumer<MouseEvent> onClick) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
        g2d.setColor(textColor);
        Font font = new Font("Arial", Font.PLAIN, 16);
        g2d.setFont(font);
        int textX = x + (width - g2d.getFontMetrics().stringWidth(text)) / 2;
        int textY = y + ((height - g2d.getFontMetrics().getHeight()) / 2) + g2d.getFontMetrics().getAscent();
        g2d.drawString(text, textX, textY);
        if (isInteractive) {
            drawables.add(new Drawable(x, y, width, height, true, onClick));
        }
    }

    public static JTextField createInputField(int x, int y, int width, int height, Font font, Color textColor, Color backgroundColor) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(font);
        textField.setForeground(textColor);
        textField.setBackground(backgroundColor);
        return textField;
    }

    public static JTextField createOutlinedInputField(int x, int y, int width, int height, Font font, Color textColor, Color backgroundColor, Color borderColor, float borderThickness) {
        JTextField textField = createInputField(x, y, width, height, font, textColor, backgroundColor);
        Border border = BorderFactory.createLineBorder(borderColor, (int) borderThickness);
        textField.setBorder(border);
        return textField;
    }

    public static JTextField RoundedInput(int x, int y, int width, int height, int radius, Font font, Color textColor, Color backgroundColor) {
        RoundedText textField = new RoundedText(radius);
        textField.setBounds(x, y, width, height);
        textField.setFont(font);
        textField.setForeground(textColor);
        textField.setBackground(backgroundColor);
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textField;
    }

    public static JTextField RoundedOutlinedInput(int x, int y, int width, int height, int radius, Font font, Color textColor, Color backgroundColor, Color borderColor, float borderThickness) {
        RoundedText textField = new RoundedText(radius);
        textField.setBounds(x, y, width, height);
        textField.setFont(font);
        textField.setForeground(textColor);
        textField.setBackground(backgroundColor);
        Border border = BorderFactory.createLineBorder(borderColor, (int) borderThickness);
        textField.setBorder(border);
        return textField;
    }


    public static void drawImageWithOutline(Graphics g, String imagePath, int x, int y, int width, int height, Color outlineColor, float thickness, boolean isInteractive, Consumer<MouseEvent> onClick) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            g.drawImage(image, x, y, width, height, null);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(outlineColor);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.drawRect(x, y, width, height);
            if (isInteractive) {
                drawables.add(new Drawable(x, y, width, height, true, onClick));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkInteractions(MouseEvent e) {
        for (Drawable drawable : drawables) {
            drawable.checkClick(e);
        }
    }
}
