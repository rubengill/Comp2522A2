import javax.swing.*;

/** Displays the window frame for the chess game
 *
 * @author rgill
 * @version 1.o
 */
public class ProgramFrame extends JFrame {

    public ProgramFrame() {
        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Creates board
        BoardFrame boardFrame = new BoardFrame(8);
        add(boardFrame);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
