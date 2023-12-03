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

        Board board = game.getBoard();
        // Create the correct number of BoardFrame objects depending on the Board type
        if (board instanceof ChessBoard3D) {
            ChessBoard3D chessBoard3D = (ChessBoard3D) board;
            for (Board b : chessBoard3D.getBoardList()) {
                BoardFrame boardFrame = new BoardFrame(b, game);
                //Initialize fist board
                if (b == chessBoard3D.getBoardList().get(0)) {
                    boardFrame.initializeBoard(game.getPlayers());
                }
                boardFrame.setBorder(border);
                add(boardFrame);
            }
        } else {
            // Set up 2D chess board
            BoardFrame boardFrame = new BoardFrame(board, game);
            boardFrame.initializeBoard(game.getPlayers());
            boardFrame.setBorder(border);
            add(boardFrame);
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}