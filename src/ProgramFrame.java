import javax.swing.*;

/**
 * Displays the window frame for the chess game
 *
 * @author rgill
 * @version 1.0
 */
public class ProgramFrame extends JFrame {

    /**
     * Initializes the main window, sets properties, and adds the board from the game object
     *
     * @param game The game object containing the board to display
     */
    public ProgramFrame(Game game) {
        setTitle("Chess Game");

        // Ensure the application exits when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create a new BoardFrame using the board from the game object and add it to this JFrame
        BoardFrame boardFrame = new BoardFrame(game.getBoard());
        add(boardFrame);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


