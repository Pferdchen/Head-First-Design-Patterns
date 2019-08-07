package headfirst.designpatterns.proxy.virtualproxy;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class ImageNotLoaded implements ImageState {
    ImageProxy2 proxy;

    Thread retrievalThread;
    boolean retrieving = false;

    public ImageNotLoaded(ImageProxy2 proxy) {
        this.proxy = proxy;
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x+300, y+190);
        if (!retrieving) {
            retrieving = true;

            retrievalThread = new Thread(() -> {
                    try {
                        proxy.setImageIcon(new ImageIcon(proxy.getImageURL(), "CD Cover"));
                        proxy.setImageState(proxy.getImageLoaded());
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            });
            retrievalThread.start();
        }
    }

}
