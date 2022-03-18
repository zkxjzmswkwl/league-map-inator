package sh.botnet;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.AWTException;

public class App implements Runnable {
    private final Rectangle minimapRect = new Rectangle(4601, 878, 500, 500);

    private BufferedImage screenie(Rectangle rect) {
        return SRobot.getRobot().createScreenCapture(rect);
    }

    // yoinked from https://stackoverflow.com/a/44783005
    // didn't want to include opencv.
    private BufferedImage scale(BufferedImage src, int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    public static void main(String[] args) throws AWTException {
        new App().run();
    }

    @Override
    public void run() {
        try {
            Gui gui = new Gui();
            Thread guiThread = new Thread(gui);
            guiThread.start();

            for (;;) {
                BufferedImage cap = this.screenie(this.minimapRect);
                cap = this.scale(cap, 500, 500);
                gui.setNewMapFrame(cap);
                Thread.sleep(12);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
