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
    private final List<Player> players;

    /** Turn of the current player */
    private Player currentPlayer;

    /** The start tile */
    private Tile tileOne;

    /** The start tile level */
    private int levOne;

    /** The end tile */
    private Tile tileTwo;

    /** The end tile level */
    private int levTwo;

    /** The selected tile frame */
    private TileFrame selectedTileFrame;

    /** Tile frame for the destination tile */
    private TileFrame destinationTileFrame;

    /**
     * Sets up a 3D Chess game. Initializes players and boards
     */
    public Game(boolean is3D) {
        players = new ArrayList<>();
        if (is3D) {
            this.board = new ChessBoard3D();
        } else {
            this.board = new Board();
        }
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
    public Board getBoard() {
        return board;
    }

    /**
     * Gets the players in the game
     * @return the players in the game
     */
    public List<Player> getPlayers() {
        return players;
    }

    public void handleTileSelection(TileFrame tileFrame) {
        Tile selectedTile = tileFrame.getTile();
        int selectedLevel = selectedTile.getLevel();

        if (selectedTileFrame == null) {
            // First tile selection
            if (selectedTile.isOccupied() && isCurrentPlayerTurn(selectedTile.getPiece())) {
                selectedTileFrame = tileFrame;
                tileOne = selectedTile;
                levOne = selectedLevel;

                selectedTileFrame.setSelected(true);
                selectedTileFrame.repaint();
            }
        } else {
            // Second tile selection
            destinationTileFrame = tileFrame;
            tileTwo = selectedTile;
            levTwo = selectedLevel;
            movePieceBetweenBoards();

            // Reset the selection
            selectedTileFrame.setSelected(false);
            destinationTileFrame.setSelected(false);
            selectedTileFrame.repaint();
            destinationTileFrame.repaint();
            selectedTileFrame = null;
            destinationTileFrame = null;
        }
    }

    /**
     * Helper method to initiate moving pieces across the boards
     */
    private void movePieceBetweenBoards() {
        ChessBoard3D chessBoard3D = (ChessBoard3D) this.board;
        chessBoard3D.movePiece(tileOne, tileTwo, levOne, levTwo);

        // Switch the turn after the move
        switchTurn();
    }
}