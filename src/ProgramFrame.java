import javax.swing.*;

/** Displays the window frame for the chess game
 *
 * @author rgill
 * @version 1.0
 */
public class ProgramFrame extends JFrame {

    /**
     * initializes the main window, sets properties, adds board
     */
    public ProgramFrame() {
        setTitle("Chess Game");
        // Ensure the application exits when the window is closed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Standard chess board size is created
        BoardFrame boardFrame = new BoardFrame(8);
        add(boardFrame);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
