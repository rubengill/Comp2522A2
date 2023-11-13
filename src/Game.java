import java.util.ArrayList;
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

    /** Board the game is played on */
    private Board board;

    /** Players in the game */
    private List<Player> players;

    /** Turn of the current player */
    private Player currentPlayer;

    /**
     * Sets up a Game. Initializes players as well as
     * the pieces on the board
     */
    public Game() {
        this.players = new ArrayList<>();
        initializePlayers();
        this.board = new Board();
    }

    /**
     * Helper method which creates the players for the game
     */
    private void initializePlayers() {
        players.add(new Player("white"));
        players.add(new Player("black"));
    }

    /**
     * Gets the current Board
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }
}