import javax.swing.ImageIcon;
import static java.io.File.separator;

import java.io.Serializable;

/**
 * <p>
 * Queen piece that extends regular piece.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Queen extends Piece implements Serializable {
    /**
     * serial id.
     */
    private static final long serialVersionUID = 4633739034418642202L;
    /**
     * Queen image.
     */
    private ImageIcon queen;

    /**
     * <p>
     * Queen constructor.
     * </p>
     * 
     * @param id
     *            id
     * @param color
     *            color
     */
    public Queen(int id, char color) {
        super(id, color);
        queen = new ImageIcon(this.getClass().getResource("/Pieces/" + color + "q.png"));
        this.setIcon(queen);
    }

    /**
     * <p>
     * Checks to see if move is valid.
     * </p>
     * 
     * @param src
     *            source, dest destinatio
     */
    @Override
    public boolean isValidMove(Square src, Square dest) {
        int srcRow = src.getRow();
        int srcCol = src.getCol();
        int destRow = dest.getRow();
        int destCol = dest.getCol();
        int playColor = src.getGamePiece().getColors();

        if (playColor == 'w') {
            if (Math.abs(srcCol - destCol) == Math.abs(srcRow - destRow) || srcRow == destRow || srcCol == destCol) {
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
                } else if (srcRow <= destRow) {
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
                    return true;
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
            if (Math.abs(srcCol - destCol) == Math.abs(srcRow - destRow) || srcRow == destRow || srcCol == destCol) {
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
                } else if (srcRow >= destRow) {
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
        return false;
    }
}