import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static final int NO_OF_TRIES = 100;
    public static final int NO_OF_THREADS = 10;
    public static final String FILES_LOCATION = "/vagrant_data/imageio/images_1px/";

    public static final File DIRECTORY = new File(FILES_LOCATION);
    public static final File[] FILES = DIRECTORY.listFiles();

    public static void main( String[] args ) throws InterruptedException {
        for (int k = 0; k < NO_OF_TRIES; k++) {
            List<Thread> threads = new ArrayList<Thread>();
            for (int i = 0; i < NO_OF_THREADS; i++) {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        for (File f : FILES) {
                            try {
                                InputStream is = new FileInputStream(f);
                                //BufferedImage image = ImageIO.read(ImageIO.createImageInputStream(is));
                                BufferedImage image = ImageIO.read(is);
                                is.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println(e.getCause());
                                System.out.println(e.toString());
                            }
                        }
                    }
                };
                threads.add(t);
            }
            for (int i = 0; i < NO_OF_THREADS; i++) {
                threads.get(i).start();
            }
            for (int i = 0; i < NO_OF_THREADS; i++) {
                threads.get(i).join();
            }
            System.out.println("."+k);
        }
    }
}
