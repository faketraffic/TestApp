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
