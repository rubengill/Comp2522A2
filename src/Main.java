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
                Game game = new Game();  // Initialize the game object
                new ProgramFrame(game);  // Pass the game object to ProgramFrame to display it
            }
        });
    }
}