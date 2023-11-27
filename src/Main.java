/**
 * Class to start the program
 *
 * @author rgill
 * @version 1.0
 */

/**
 * Drives the program
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialize the game object
                Game game = new Game(true);
                // Pass the game object to ProgramFrame to display it
                new ProgramFrame(game);
            }
        });
    }
}