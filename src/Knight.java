import javax.swing.ImageIcon;
import static java.io.File.separator;

import java.io.Serializable;

/**
 * <p>
 * Knight class that extends Peice.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Knight extends Piece implements Serializable {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = 3634028129458405882L;
    /**
     * <p>
     * Image for Knight.
     * </p>
     */
    private ImageIcon knight;

    /**
     * <p>
     * Knight constructor.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */
    public Knight(int id, char color) {
        super(id, color);
        knight = new ImageIcon(this.getClass().getResource("/Pieces/" + color + "n.png"));
        this.setIcon(knight);
    }

    /**
     * <p>
     * Checks to see if move is valid.
     * </p>
     * 
     * @param src
     *            source, dest destination
     */
    @Override
    public boolean isValidMove(Square src, Square dest) {
        int srcRow = src.getRow();
        int srcCol = src.getCol();
        int destRow = dest.getRow();
        int destCol = dest.getCol();
        int playColor = src.getGamePiece().getColors();

        if (playColor == 'w') {
            if ((destRow - srcRow == 2 && destCol - srcCol == -1) || (destRow - srcRow == 2 && destCol - srcCol == 1)
                    || (srcRow - destRow == 2 && destCol - srcCol == -1)
                    || (srcRow - destRow == 2 && destCol - srcCol == 1)
                    || (destRow - srcRow == 1 && destCol - srcCol == -2)
                    || (destRow - srcRow == 1 && destCol - srcCol == 2)
                    || (srcRow - destRow == 1 && destCol - srcCol == -2)
                    || (srcRow - destRow == 1 && destCol - srcCol == 2)) {
                return true;
            }
        }

        if (playColor == 'b') {
            if ((destRow - srcRow == 2 && destCol - srcCol == -1) || (destRow - srcRow == 2 && destCol - srcCol == 1)
                    || (srcRow - destRow == 2 && destCol - srcCol == -1)
                    || (srcRow - destRow == 2 && destCol - srcCol == 1)
                    || (destRow - srcRow == 1 && destCol - srcCol == -2)
                    || (destRow - srcRow == 1 && destCol - srcCol == 2)
                    || (srcRow - destRow == 1 && destCol - srcCol == -2)
                    || (srcRow - destRow == 1 && destCol - srcCol == 2)) {
                return true;
            }
        }
        return false;
    }
}