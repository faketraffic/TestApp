package play.tharmsy.utlits;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedText extends JTextField {
    private int radius;

    public RoundedText(int radius) {
        super();
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2d.dispose();
    }

    @Override
    public void setBorder(Border border) {
        super.setBorder(new EmptyBorder(4, 8, 4, 8));
    }
}
