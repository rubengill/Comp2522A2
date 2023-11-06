import java.util.List;

/**
 * Defines players, contains rules and high level moves that pertain to
 * the game being played. Switches turns between players. Instantiates a
 * Board object.
 *
 * @author rgill
 * @version 1.0
 */
public class Game {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
    }

    public Board getBoard() {
        return board;
    }
}