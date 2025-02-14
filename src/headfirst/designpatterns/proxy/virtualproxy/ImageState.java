package headfirst.designpatterns.proxy.virtualproxy;

import java.awt.Component;
import java.awt.Graphics;

public interface ImageState {
    int getIconWidth();
    int getIconHeight();
    void paintIcon(final Component c, Graphics  g, int x,  int y);
}
