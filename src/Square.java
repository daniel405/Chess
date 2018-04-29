import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * Square class.
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Square extends JPanel implements Serializable {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = -7539356237569133293L;
    private final int row;
    private final int col;
    public Square[][] squares;
    /**
     * <p>
     * Game piece.
     * </p>
     */
    private Piece gamePiece;

    /**
     * <p>
     * Gets current game piece.
     * </p>
     * 
     * @return gamePeice
     */
    public Piece getGamePiece() {
        return gamePiece;
    }

    /**
     * <p>
     * Sets new game piece.
     * </p>
     * 
     * @param gamePiece
     *            gamePiece
     */
    public void setGamePiece(Piece gamePiece) {
        this.gamePiece = gamePiece;
        this.add(gamePiece);
    }

    /**
     * <p>
     * Removes game piece.
     * </p>
     */
    public void removeGamePiece() {
        this.remove(gamePiece);
        this.gamePiece = null;
    }

    /**
     * <p>
     * Color of square.
     * </p>
     */
    private Color color;

    /**
     * <p>
     * Move listener.
     * </p>
     */
    public String getGamePiece;

    /**
     * <p>
     * Color of square.
     * </p>
     * 
     * @param color
     *            color
     */
    public Square(int x, int y, Color color) {
        this.row = x;
        this.col = y;
        this.color = color;
        this.setBackground(color);
        Dimension localDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int i1 = (int) (1.0 / Chess.CHESS * Math.min(localDimension.width * 0.75, localDimension.height * 0.75));
        Rectangle localRectangle = new Rectangle();
        localRectangle.setBounds(((localDimension.width - i1) / 2), ((localDimension.height - i1) / 2), i1, i1);
        setBounds(localRectangle);
    }

    /**
     * <p>
     * Graphics canvas.
     * </p>
     * 
     * @param graphics
     *            graphics
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        ;
    }

    /**
     * <p>
     * Gets color square.
     * </p>
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}