package play.tharmsy.utlits;

import java.awt.*;

public class Render {
    public static void drawRoundedSquare(Graphics g, int x, int y, int size, int arcWidth, int arcHeight, int red, int green, int blue) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(red, green, blue));
        g2d.fillRoundRect(x, y, size, size, arcWidth, arcHeight);
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
