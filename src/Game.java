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
     * Sets up a Game. Initializes players and boards
     */
    public Game() {
        //Instantiate the Board (Either 2D or 3D)
        this.board = new Board();
        this.players = new ArrayList<>();
        initializePlayers();
    }

    /**
     * Helper method which creates the players for the game
     */
    private void initializePlayers() {
        Player white = new Player("white");
        Player black = new Player("black");
        players.add(white);
        players.add(black);
        currentPlayer = white;
    }

    /**
     * Switches the turn to the next player.
     */
    public void switchTurn() {
        currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
    }

    /**
     * Checks if it is the current player's turn based on the piece.
     * @param piece The piece to check.
     * @return true if it's the current player's piece
     */
    public boolean isCurrentPlayerTurn(Piece piece) {
        return currentPlayer.ownsPiece(piece);
    }

    /**
     * Gets the current Board
     * @return the board
     */
    public Board getBoard(int i) {
        return boards.get(i);
    }

    /**
     * Gets the players in the game
     * @return the players in the game
     */
    public List<Player> getPlayers() {
        return players;
    }
}