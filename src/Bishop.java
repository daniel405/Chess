import javax.swing.ImageIcon;
import java.io.Serializable;

/**
 * <p>
 * Bishop class that extends Piece.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Bishop extends Piece implements Serializable {
    /**
     * SerialId.
     */
    private static final long serialVersionUID = -1556040669466017039L;
    private Board board;
    /**
     * <p>
     * Image for bishop.
     * </p>
     */
    private ImageIcon bishop;

    /**
     * <p>
     * Bishop constructor.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */
    public Bishop(int id, char color) {
        super(id, color);
        bishop = new ImageIcon(this.getClass().getResource("/Pieces/" + color + "b.png"));
        this.setIcon(bishop);
    }

    /**
     * <p>
     * Checks to see if move is valid.
     * </p>
     * 
     * @param src
     *            square1, dest square2
     */
    @Override
    public boolean isValidMove(Square src, Square dest) {
        int srcRow = src.getRow();
        int srcCol = src.getCol();
        int destRow = dest.getRow();
        int destCol = dest.getCol();
        int playColor = src.getGamePiece().getColors();

        if (srcCol != destCol && srcRow != destRow) {
            if (playColor == 'w') {
                if (Math.abs(srcCol - destCol) == Math.abs(srcRow - destRow)) {
                    if (srcRow <= destRow) {
                        if (srcCol >= destCol) {
                            for (int i = srcCol - 1, j = srcRow + 1; i > destCol; j++, i--) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        }
                        if (srcCol <= destCol) {
                            for (int i = srcCol + 1, j = srcRow + 1; i < destCol; j++, i++) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        }

                    } else if (srcRow >= destRow) {
                        if (srcCol >= destCol) {
                            for (int i = srcCol - 1, j = srcRow - 1; i > destCol; j--, i--) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        }
                        if (srcCol <= destCol) {
                            for (int i = srcCol + 1, j = srcRow - 1; i < destCol; j--, i++) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }

            if (playColor == 'b') {
                if (Math.abs(srcCol - destCol) == Math.abs(srcRow - destRow)) {
                    if (srcRow >= destRow) {
                        if (srcCol >= destCol) {
                            for (int i = srcCol - 1, j = srcRow - 1; i > destCol; j--, i--) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        } else if (srcCol <= destCol) {
                            for (int i = srcCol + 1, j = srcRow - 1; i < destCol; j--, i++) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        }
                    } else if (srcRow <= destRow) {
                        if (srcCol >= destCol) {
                            for (int i = srcCol - 1, j = srcRow + 1; i > destCol; j++, i--) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        } else if (srcCol <= destCol) {
                            for (int i = srcCol + 1, j = srcRow + 1; i < destCol; j++, i++) {
                                if (Board.getSquare(j, i).getGamePiece() != null) {
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}