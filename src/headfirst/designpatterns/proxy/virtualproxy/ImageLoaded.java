package headfirst.designpatterns.proxy.virtualproxy;

import java.awt.Component;
import java.awt.Graphics;

public class ImageLoaded implements ImageState {
    ImageProxy2 proxy;

    public ImageLoaded(ImageProxy2 proxy) {
        this.proxy = proxy;
    }

    @Override
    public int getIconWidth() {
        return proxy.getImageIcon().getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return proxy.getImageIcon().getIconHeight();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        proxy.getImageIcon().paintIcon(c, g, x, y);
    }

}
