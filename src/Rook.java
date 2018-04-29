import javax.swing.ImageIcon;
import static java.io.File.separator;

import java.io.Serializable;

/**
 * <p>
 * Rook class that extends Piece.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Rook extends Piece implements Serializable {
    private Board board;
    private Piece id;
    /**
     * <p>
     * Image for Rook.
     * </p>
     */
    private ImageIcon rook;

    /**
     * <p>
     * Rook constructor.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */
    public Rook(int id, char color) {
        super(id, color);
        rook = new ImageIcon(this.getClass().getResource("/Pieces/" + color + "r.png"));
        this.setIcon(rook);

    }

    /**
     * <p>
     * Checks to see if move is valid.
     * </p>
     * 
     * @param src
     *            source, dest square
     */
    @Override
    public boolean isValidMove(Square src, Square dest) {
        int srcRow = src.getRow();
        int srcCol = src.getCol();
        int destRow = dest.getRow();
        int destCol = dest.getCol();
        int playColor = src.getGamePiece().getColors();

        if (playColor == 'w') {
            if (srcRow == destRow || srcCol == destCol) {
                if (srcRow == destRow) {
                    if (srcCol <= destCol) {
                        for (int i = srcCol + 1; i < destCol; ++i) {
                            if (Board.getSquare(srcRow, i).getGamePiece() != null) {
                                return false;
                            }
                        }
                    } else if (srcCol >= destCol) {
                        for (int i = srcCol - 1; i > destCol; --i) {
                            if (Board.getSquare(srcRow, i).getGamePiece() != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else if (srcCol == destCol) {
                    if (srcRow <= destRow) {
                        for (int i = srcRow + 1; i < destRow; ++i) {
                            if (Board.getSquare(i, srcCol).getGamePiece() != null) {
                                return false;
                            }
                        }
                    } else if (srcRow >= destRow) {
                        for (int i = srcRow - 1; i > destRow; --i) {
                            if (Board.getSquare(i, srcCol).getGamePiece() != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }

        if (playColor == 'b') {
            if (srcRow == destRow || srcCol == destCol) {
                if (srcRow == destRow) {
                    if (srcCol <= destCol) {
                        for (int i = srcCol + 1; i < destCol; ++i) {
                            if (Board.getSquare(srcRow, i).getGamePiece() != null) {
                                return false;
                            }
                        }
                    } else if (srcCol >= destCol) {
                        for (int i = srcCol - 1; i > destCol; --i) {
                            if (Board.getSquare(srcRow, i).getGamePiece() != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else if (srcCol == destCol) {
                    if (srcRow <= destRow) {
                        for (int i = srcRow + 1; i < destRow; ++i) {
                            if (Board.getSquare(i, srcCol).getGamePiece() != null) {
                                return false;
                            }
                        }
                    } else if (srcRow >= destRow) {
                        for (int i = srcRow - 1; i > destRow; --i) {
                            if (Board.getSquare(i, srcCol).getGamePiece() != null) {
                                return false;
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