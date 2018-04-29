import java.io.Serializable;

import javax.swing.JLabel;

public abstract class Piece extends JLabel implements Serializable {

    /**
     *  Serial id.
     */
    private static final long serialVersionUID = 789602544915608632L;
    /**
     * <p>
     * Square.
     * </p>
     */
    protected Square square;
    /**
     * <p>
     * Chess piece id.
     * </p>
     */
    protected int id;
    /**
     * <p>
     * Color of chess piece.
     * </p>
     */
    protected char color;

    /**
     * <p>
     * Chess piece.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */
    protected Piece(int id, char color) {
        this.id = id;
        this.color = color;

    }

    /**
     * <p>
     * Returns color of piece (w or b).
     * </p>
     * 
     * @return color
     */
    public char getColors() {
        return color;
    }

    public int getId() {
        return id;
    }

    /**
     * <p>
     * Checks if move is valid.
     * </p>
     * 
     * @param var1
     *            var1
     * @param var2
     *            var2
     * @return value
     */
    public abstract boolean isValidMove(Square var1, Square var2);
}