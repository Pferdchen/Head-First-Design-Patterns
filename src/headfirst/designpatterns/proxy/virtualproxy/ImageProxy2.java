package headfirst.designpatterns.proxy.virtualproxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy2 implements Icon {

    ImageState imageNotLoaded;
    ImageState imageLoaded;
    ImageState imageState;

    volatile ImageIcon imageIcon;
    final URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageProxy2(URL url) {
        imageNotLoaded = new ImageNotLoaded(this);
        imageLoaded = new ImageLoaded(this);
        imageState = imageNotLoaded;

        imageURL = url;
    }

    @Override
    public int getIconHeight() {
        return imageState.getIconHeight();
    }

    @Override
    public int getIconWidth() {
        return imageState.getIconWidth();
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    ImageIcon getImageIcon() {
        return imageIcon;
    }

    URL getImageURL() {
        return imageURL;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        imageState.paintIcon(c, g, x, y);
    }

    public void setImageState(ImageState imageState) {
        this.imageState = imageState;
    }

    public ImageState getImageNotLoaded() {
        return imageNotLoaded;
    }

    public ImageState getImageLoaded() {
        return imageLoaded;
    }

}
