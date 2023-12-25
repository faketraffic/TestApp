package play.tharmsy.utlits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Render {
    public static void drawRoundedSquare(Graphics g, int x, int y, int size, int arcWidth, int arcHeight, int red, int green, int blue) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.fillRoundRect(x, y, size, size, arcWidth, arcHeight);
    }

    public static void drawImageWithOutline(Graphics g, String imageName, int x, int y, int width, int height, Color outlineColor, float thickness) {
        try {
            // Use full path to load the image (will be fixed later)
            String fullPath = "C:/Users/tharm/Desktop/Test App/src/main/resources/Test/" + imageName + ".png";
            BufferedImage image = ImageIO.read(new File(fullPath));
            g.drawImage(image, x, y, width, height, null);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(outlineColor);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.drawRect(x, y, width, height);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading image from: " + imageName);
        }
    }
    public static void drawOutlineSquare(Graphics g, int x, int y, int size, int red, int green, int blue, float thickness, int arcWidth, int arcHeight) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRoundRect(x, y, size, size, arcWidth, arcHeight);
    }

    public static void drawGradientRoundedSquare(Graphics g, int x, int y, int size, int arcWidth, int arcHeight, Color startColor, Color endColor) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(
                new Point(x, y), startColor,
                new Point(x + size, y + size), endColor,
                true);
        g2d.setPaint(gradientPaint);
        g2d.fillRoundRect(x, y, size, size, arcWidth, arcHeight);
    }

    public static void drawRoundedButton(Graphics g, int x, int y, int width, int height, int arcWidth, int arcHeight, int red, int green, int blue, String text, Color textColor) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
        g2d.setColor(textColor);
        Font font = new Font("Arial", Font.PLAIN, 16);
        g2d.setFont(font);
        int textX = x + (width - g2d.getFontMetrics().stringWidth(text)) / 2;
        int textY = y + (height - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent();
        g2d.drawString(text, textX, textY);
    }

    public static void drawShadowedRoundedSquare(Graphics g, int x, int y, int size, int arcWidth, int arcHeight, int red, int green, int blue, int shadowSize, int shadowRed, int shadowGreen, int shadowBlue) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(shadowRed, shadowGreen, shadowBlue, 128));
        g2d.fillRoundRect(x + shadowSize, y + shadowSize, size, size, arcWidth, arcHeight);

        g2d.setColor(new Color(red, green, blue));
        g2d.fillRoundRect(x, y, size, size, arcWidth, arcHeight);
    }
}
