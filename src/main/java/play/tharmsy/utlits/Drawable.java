package play.tharmsy.utlits;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class Drawable {
    Rectangle bounds;
    Consumer<MouseEvent> onClick;
    boolean isInteractive;

    public Drawable(int x, int y, int width, int height, boolean isInteractive, Consumer<MouseEvent> onClick) {
        this.bounds = new Rectangle(x, y, width, height);
        this.isInteractive = isInteractive;
        this.onClick = onClick;
    }

    public void checkClick(MouseEvent e) {
        if (isInteractive && bounds.contains(e.getPoint())) {
            onClick.accept(e);
        }
    }

// todo add hover and click effects
}
