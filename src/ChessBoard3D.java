import java.util.ArrayList;
import java.util.List;

/**
 * Contains 3 Boards. Pieces can move between each board
 *
 * @author rgill
 * @version 1.0
 */
public class ChessBoard3D extends Board {

    /** Contains a list of the boards. */
    private final List<Board> boardList = new ArrayList<>();

    /**
     * Creates a ChessBoard3D object which contains 3 Boards
     */
    public ChessBoard3D() {
        // Instantiate and add  Boards to the list
        for (int i = 0; i < 3; i++) {
            boardList.add(new Board());
            System.out.println("Number of boards in the list: " + boardList.size());
        }
    }

    /** Gets the list containing the boards. */
    public List<Board> getBoardList() {
        return boardList;
    }
}
