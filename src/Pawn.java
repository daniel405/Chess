import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * <p>
 * Pawn class that extends Piece.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Pawn extends Piece implements Serializable {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = -4304433157909204107L;
    /**
     * <p>
     * Image for Pawn.
     * </p>
     */
    private ImageIcon pawn;
    public int moveCount = 0;
    private MoveListener moveListener;
    private Square square;

    /**
     * <p>
     * Pawn constructor.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */

    public Pawn(int id, char color) {
        super(id, color);
        pawn = new ImageIcon(this.getClass().getResource("/Pieces/" + color + "p.png"));
        this.setIcon(pawn);
    }

    /**
     * <p>
     * Checks to see if move is valid.
     * </p>
     * 
     * @param src
     *            source, dest destination
     * 
     */

    @Override
    public boolean isValidMove(Square src, Square dest) {
        int srcRow = src.getRow();
        int srcCol = src.getCol();
        int destRow = dest.getRow();
        int destCol = dest.getCol();
        int playColor = src.getGamePiece().getColors();

        if (playColor == 'w' && srcRow < destRow) {
            if (srcRow == 1 && destCol == srcCol) {
                if (Board.getSquare(srcRow + 1, destCol).getGamePiece() != null) {
                    if (dest.getGamePiece() != null) {
                        return true;
                    }
                    return false;
                }
                if ((destRow - srcRow <= 2) || (dest.getGamePiece() != null && destCol - srcCol <= Math.abs(1))) {
                    return true;
                }
            } else if ((srcRow != 1) && (destCol == srcCol && dest.getGamePiece() != null)) {
                return false;
            } else if ((srcRow != 1 && destCol == srcCol)
                    || (dest.getGamePiece() != null && destCol - srcCol <= Math.abs(1))) {
                if (destRow - srcRow <= 1) {
                    return true;
                }
            }
        }

        if (playColor == 'b' && srcRow > destRow) {
            if (srcRow == 6 && destCol == srcCol) {
                if (Board.getSquare(srcRow - 1, destCol).getGamePiece() != null) {
                    if (dest.getGamePiece() != null) { 
                        return true;
                    }
                    return false;
                }
                if (srcRow - destRow <= 2) {
                    return true;
                }
            } else if ((srcRow != 1) && (destCol == srcCol && dest.getGamePiece() != null)) {
                return false;
            } else if ((srcRow != 6 && destCol == srcCol)
                    || (dest.getGamePiece() != null && destCol - srcCol <= Math.abs(1))) {
                if (srcRow - destRow <= 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
