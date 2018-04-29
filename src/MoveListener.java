import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * <p>
 * Listens to mouse movements and actions.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */

public class MoveListener implements MouseListener, Serializable {
    /**
     * Serial Id.
     */
    private static final long serialVersionUID = -110438135889044517L;
    /**
     * Square.
     */
    public Square square;
    /**
     * Board.
     */
    public Board board;

    /**
     * <p>
     * Initial square clicked.
     * </p>
     */
    public Square startSquare;
    /**
     * <p>
     * Initial piece clicked.
     * </p>
     */
    public Piece startPiece;
    /**
     * <p>
     * Boolean that determines if piece is selected or not.
     * </p>
     */
    public boolean selected;

    /**
     * <p>
     * Determines which players turn it is.
     * </p>
     */
    public int player = 1;
    /**
     * <p>
     * Determines what turn it is.
     * </p>
     */
    public int turn = 1;

    /**
     * <p>
     * Move listener.
     * </p>
     */
    public MoveListener() {
    }

    /**
     * <p>
     * Mouse is clicked.
     * </p>
     * 
     * @param event
     *            event
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        Square square = (Square) event.getSource();
        if (!selected) {
            try {
                if ((square.getGamePiece() != null) 
                        && (player == 1 && square.getGamePiece().getColors() == 'b')) {
                    JOptionPane.showMessageDialog(null, 
                            "It's white's turn!", "Oops", JOptionPane.INFORMATION_MESSAGE);
                } else if ((square.getGamePiece() != null)
                        && (player == 0 && square.getGamePiece().getColors() == 'w')) {
                    JOptionPane.showMessageDialog(null, 
                            "It's black's turn!", "Oops", JOptionPane.INFORMATION_MESSAGE);
                }
                if ((square.getGamePiece() != null) 
                        && (player == 1 && square.getGamePiece().getColors() == 'w')
                        || (player == 0 && square.getGamePiece().getColors() == 'b')) {
                    startPiece = square.getGamePiece();
                    startSquare = square;
                    square.setBackground(Color.decode("#83976a"));
                    selected = true;
                } else if (square.getGamePiece() == null) {
                    selected = false;
                }
            } catch (NullPointerException e1) {
                // ignore case where neither w or b piece is chosen.
            }
        } else if (selected) {
            if (square.getGamePiece() != null) {
                try {
                    if (startSquare.getGamePiece().isValidMove(startSquare, square) == true) {
                        if (square.getGamePiece().getColors() != startPiece.getColors()) {
                            square.removeGamePiece();
                            square.repaint();
                            square.setGamePiece(startPiece);
                            startSquare.repaint();
                            startSquare.setBackground(startSquare.getColor());
                            startSquare.removeGamePiece();
                            switchPlayer();
                            selected = false;
                        } else {
                            startSquare.setBackground(startSquare.getColor());
                            selected = false;
                        }
                    } else {
                        startSquare.setBackground(startSquare.getColor());
                        selected = false;
                    }
                } catch (Exception e1) {
                    //
                }

            } else if (square.getGamePiece() == null) {
                try {
                    if (startSquare.getGamePiece().isValidMove(startSquare, square) == true) {
                        square.setGamePiece(startPiece);
                        square.repaint();
                        startSquare.repaint();
                        startSquare.setBackground(startSquare.getColor());
                        startSquare.removeGamePiece();
                        switchPlayer();
                        selected = false;
                    } else {
                        startSquare.setBackground(startSquare.getColor());
                        selected = false;
                    }
                } catch (Exception e1) {
                    //
                }
            } else {
                startSquare.setBackground(startSquare.getColor());
                selected = false;
            }
        }

    }

    /**
     * <p>
     * Mouse is pressed.
     * </p>
     * 
     * @param event
     *            event
     */
    @Override
    public void mousePressed(MouseEvent event) {
        Square square = (Square) event.getSource();

    }

    /**
     * <p>
     * Mouse is released.
     * </p>
     * 
     * @param event
     *            event
     */
    @Override
    public void mouseReleased(MouseEvent event) {

    }

    /**
     * <p>
     * Mouse is entered.
     * </p>
     * 
     * @param event
     *            event
     */
    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    /**
     * <p>
     * Mouse is exited.
     * </p>
     * 
     * @param event
     *            event
     */
    @Override
    public void mouseExited(MouseEvent event) {
        // TODO Auto-generated method stub

    }

    /**
     * <p>
     * Switches player to move.
     * </p>
     */
    public void switchPlayer() {
        if (this.turn == 1) {
            this.player = 0;
            this.turn = 0;
        } else {
            this.player = 1;
            this.turn = 1;
        }
    }

    /**
     * Returns current player.
     * 
     * @return player player
     */
    public int getPlayer() {
        return this.player;
    }

    /**
     * Set current player.
     * 
     * @param player
     *            player
     */
    public void setPlayer(int player) {
        this.player = player;
        this.turn = player;

    }

}
