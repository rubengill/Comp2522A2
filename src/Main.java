/** Class to start the program
 *
 * @author rgill
 * @version 1.o
 */

/**
 * Drives the program
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ProgramFrame();
            }
        });
    }
}