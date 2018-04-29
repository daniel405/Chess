import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * <p>
 * King class that extends Peice.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class King extends Piece implements Serializable {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = -1942923705286222666L;
    /**
     * <p>
     * Image for King.
     * </p>
     */
    private ImageIcon king;

    /**
     * <p>
     * King.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */
    public King(int id, char color) {
        super(id, color);
        king = new ImageIcon(this.getClass().getResource("/Pieces/" + color + "k.png"));
        this.setIcon(king);
    }

    /**
     * <p>
     * Checks to see if move is valid.
     * </p>
     * 
     * @param square
     *            square
     */
    @Override
    public boolean isValidMove(Square src, Square dest) {
        int srcRow = src.getRow();
        int srcCol = src.getCol();
        int destRow = dest.getRow();
        int destCol = dest.getCol();
        int playColor = src.getGamePiece().getColors();

        if (playColor == 'w') {
            if (destRow - srcRow <= 1 && destCol - srcCol <= 1 && destRow - srcRow >= -1 && destCol - srcCol >= -1) {
                return true;
            }
        }

        else if (playColor == 'b') {
            if (srcRow - destRow <= 1 && srcCol - destCol <= 1 && srcRow - destRow >= -1 && srcCol - destCol >= -1) {
                return true;
            }
        }
        return false;
    }
}