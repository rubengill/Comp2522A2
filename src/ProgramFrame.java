import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create border between the boards
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // Create 3 BoardFrame objects using the board and players from the game object and add it to this JFrame
        for (int i = 0; i < 3; i++) {
            Board board = game.getBoard(i);
            BoardFrame boardFrame = new BoardFrame(board, game.getPlayers(), game);
            boardFrame.setBorder(border);
            add(boardFrame);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


