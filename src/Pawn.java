public class Pawn extends Piece {

    /**
     * Checks if a path is valid
     *
     * @return true if move is valid
     */
    @Override
    public boolean isValidMove() {
        return false;
    }

    /**
     * Checks if it can move through an obstructed path
     *
     * @return true if it can move through a piece
     */
    @Override
    public boolean canMoveThrough() {
        return false;
    }
}
