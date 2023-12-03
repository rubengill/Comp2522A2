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
        for (int level = 0; level < 3; level++) {
            boardList.add(new Board(level));
            System.out.println("Number of boards in the list: " + boardList.size());
        }
    }

    /**
     *
     * @param startTile starting tile
     * @param endTile end tile
     * @return path containing all the tiles the user wants to move
     */
    public List<Tile> getPath(Tile startTile, int startLevel, Tile endTile, int endLevel) {
        List<Tile> path = new ArrayList<>();
        // Start and end coordinates
        int startX = -1, startY = -1, endX = -1, endY = -1;

        Board startBoard = boardList.get(startLevel);
        Board endBoard = boardList.get(endLevel);

        // Find coordinates of the start tile
        for (int x = 0; x < startBoard.tiles.length; x++) {
            for (int y = 0; y < startBoard.tiles[x].length; y++) {
                if (startBoard.tiles[x][y] == startTile) {
                    startX = x;
                    startY = y;
                    break;
                }
            }
        }

        // Find coordinates of the end tile
        for (int x = 0; x < endBoard.tiles.length; x++) {
            for (int y = 0; y < endBoard.tiles[x].length; y++) {
                if (endBoard.tiles[x][y] == endTile) {
                    endX = x;
                    endY = y;
                    break;
                }
            }
        }

        // Check if coordinates were found
        if (startX == -1 || endX == -1) {
            System.out.println("Could not find the tiles in the tiles array!");
            return path;
        }

        int xDirection = Integer.compare(endX, startX);
        int yDirection = Integer.compare(endY, startY);
        int levelDirection = Integer.compare(endLevel, startLevel);

        if (startLevel == endLevel) {
            // Movement on the same board
            for (int x = startX + xDirection, y = startY + yDirection; x != endX || y != endY; x += xDirection, y += yDirection) {
                path.add(startBoard.tiles[x][y]);
            }
        } else {
            // Movement across levels
            int x = startX, y = startY;
            for (int level = startLevel + levelDirection; level != endLevel; level += levelDirection) {
                x += xDirection;
                y += yDirection;

                // Check if we're out of bounds
                if (x < 0 || x >= startBoard.tiles.length || y < 0 || y >= startBoard.tiles[0].length) {
                    break;
                }
                Board currentBoard = boardList.get(level);
                path.add(currentBoard.tiles[x][y]);
            }
        }
        if (!path.contains(endTile) && !endTile.equals(startTile)) {
            path.add(endTile);
        }
        return path;
    }

    /**
     *
     * @param startTile the start tile
     * @param endTile the end tile
     * @param startLevel level of the start tile
     * @param endLevel level of the end tile
     */
    public void movePiece(Tile startTile, Tile endTile, int startLevel, int endLevel) {
            Board startBoard = boardList.get(startLevel);
            Board endBoard = boardList.get(endLevel);

            // Find the coordinates of the start tile on the start board
            int startX = -1, startY = -1, endX = -1, endY = -1;
            for (int x = 0; x < startBoard.tiles.length; x++) {
                for (int y = 0; y < startBoard.tiles[x].length; y++) {
                    if (startBoard.tiles[x][y] == startTile) {
                        startX = x;
                        startY = y;
                    }
                    if (endBoard.tiles[x][y] == endTile) {
                        endX = x;
                        endY = y;
                    }
                }
            }

            System.out.println("3D Move from (x1, y1): (" + startX + ", " + startY + ") to (x2, y2): (" + endX + ", " + endY + ")");
            if (isValidDiagonal(startLevel, endLevel, startX, endX, startY, endY)) {
                Piece movingPiece = startBoard.tiles[startX][startY].getPiece();
                if (movingPiece.isValidMove(startX, startY, endX, endY) && isValidDiagonal(startLevel, endLevel, startX, endX, startY, endY)) {
                    if (!(movingPiece instanceof Knight)) {
                        List<Tile> path = getPath(startTile, startLevel, endTile, endLevel);
                        if (!movingPiece.canMoveThrough(path)) {
                            System.out.println("Path is blocked, move not executed");
                            return;
                        }
                    }

                    // Perform the move
                    endBoard.tiles[endX][endY].setPiece(movingPiece);
                    startBoard.tiles[startX][startY].setPiece(null);
                } else {
                    System.out.println("Invalid move");
                }
            }
    }

    /** Checks if diagonal is valid */
    private boolean isValidDiagonal(int startLevel, int endLevel, int startX, int endX, int startY, int endY) {
        int levelDifference = Math.abs(startLevel - endLevel);
        int horizontalDistance = Math.max(Math.abs(startX - endX), Math.abs(startY - endY));

        if (levelDifference == 0) {
            // Normal movement on the same board
            return true;
        } else if (levelDifference == 1) {
            return horizontalDistance <= 1;
        } else if (levelDifference == 2) {
            return horizontalDistance <= 2;
        }
        return false;
    }

    /** Gets the list containing the boards. */
    public List<Board> getBoardList() {
        return boardList;
    }
}
