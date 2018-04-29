import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * <p>
 * Board settings.
 * </p>
 * 
 * @author danielkatz
 * @version 1.0
 */
public class Board extends JFrame implements Serializable {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = 1036707457261917544L;

    /**
     * <p>
     * Double array of squares.
     * </p>
     */
    private static Square[][] squares;

    /**
     * <p>
     * Move listener.
     * </p>
     */
    private MoveListener moveListener;

    /**
     * <p>
     * Board GUI.
     * </p>
     * 
     * @param gameName
     *            gameName
     */
    public Board(String gameName) {
        super(gameName);
        squares = new Square[Chess.CHESS][Chess.CHESS];
        moveListener = new MoveListener();
        this.setLayout(new GridLayout(Chess.CHESS, Chess.CHESS));
        initBoard();
        initPiece();
        initMenu();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.centre();
        this.setVisible(true);
    }

    /**
     * <p>
     * Initialized board.
     * </p>
     */
    public void initBoard() {
        for (int i = 0; i < Chess.CHESS; ++i) {
            for (int j = 0; j < Chess.CHESS; ++j) {
                if ((i + j) % 2 == 0) {
                    squares[i][j] = new Square(i, j, Color.decode("#b58863"));
                    this.add(squares[i][j]);
                } else {
                    squares[i][j] = new Square(i, j, Color.decode("#f0d9b5"));
                    this.add(squares[i][j]);
                }
                squares[i][j].addMouseListener(moveListener);
            }
        }
    }

    /**
     * <p>
     * Initialized pieces.
     * </p>
     */
    public void initPiece() {
        for (int i = 0; i < Chess.CHESS; i++) {
            squares[1][i].setGamePiece(new Pawn(i, 'w'));
        }
        squares[0][0].setGamePiece(new Rook(1, 'w'));
        squares[0][1].setGamePiece(new Knight(1, 'w'));
        squares[0][2].setGamePiece(new Bishop(1, 'w'));
        squares[0][3].setGamePiece(new Queen(1, 'w'));
        squares[0][4].setGamePiece(new King(1, 'w'));
        squares[0][5].setGamePiece(new Bishop(2, 'w'));
        squares[0][6].setGamePiece(new Knight(2, 'w'));
        squares[0][7].setGamePiece(new Rook(2, 'w'));

        for (int i = 0; i < Chess.CHESS; i++) {
            squares[6][i].setGamePiece(new Pawn(i, 'b'));
        }
        squares[7][0].setGamePiece(new Rook(1, 'b'));
        squares[7][1].setGamePiece(new Knight(1, 'b'));
        squares[7][2].setGamePiece(new Bishop(1, 'b'));
        squares[7][3].setGamePiece(new Queen(1, 'b'));
        squares[7][4].setGamePiece(new King(1, 'b'));
        squares[7][5].setGamePiece(new Bishop(2, 'b'));
        squares[7][6].setGamePiece(new Knight(2, 'b'));
        squares[7][7].setGamePiece(new Rook(2, 'b'));
    }

    /**
     * <p>
     * Initializes menu for JFrame.
     * </p>
     */
    public void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        menuBar.add(file);
        file.add(save);
        file.add(load);

        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                moveListener.setPlayer(moveListener.getPlayer() - 1);
                resetBoard();
                loadGame();
                repaintBoard();

            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                saveGame();
                repaintBoard();
            }
        });

        this.setJMenuBar(menuBar);
    }

    private void resetBoard() {
        for (int i = 0; i < Chess.CHESS; ++i) {
            for (int j = 0; j < Chess.CHESS; ++j) {
                this.remove(squares[i][j]);
            }
        }
    }

    private void repaintBoard() {
        for (int i = 0; i < Chess.CHESS; ++i) {
            for (int j = 0; j < Chess.CHESS; ++j) {
                squares[i][j].repaint();
            }
        }
    }

    @SuppressWarnings("resource")
    private void loadGame() {
        try {
            JFileChooser open = new JFileChooser();
            String file = "";
            String path = "";
            int windowVal = open.showOpenDialog(this);
            if (windowVal == JFileChooser.APPROVE_OPTION) {
                file = open.getSelectedFile().getName();
                path = open.getCurrentDirectory().toString();
            }
            if (windowVal == JFileChooser.CANCEL_OPTION) {
                return;
            }
            FileInputStream fileIn = new FileInputStream(path + "/" + file);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            for (int i = 0; i < Chess.CHESS; ++i) {
                for (int j = 0; j < Chess.CHESS; ++j) {
                    squares[i][j] = (Square) in.readObject();
                    this.add(squares[i][j]);
                    squares[i][j].addMouseListener(moveListener);
                }
            }
            in.close();
            fileIn.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("Failed to load data.");
        } catch (ClassNotFoundException e2) {
            System.out.println("Chess class not found");
        }
    }

    private void saveGame() {
        try {
            JFileChooser open = new JFileChooser();
            String file = "";
            String path = "";
            int windowVal = open.showSaveDialog(this);
            if (windowVal == JFileChooser.APPROVE_OPTION) {
                file = open.getSelectedFile().getName();
                path = open.getCurrentDirectory().toString();
            }
            if (windowVal == JFileChooser.CANCEL_OPTION) {
                return;
            }
            FileOutputStream fileOut = new FileOutputStream(path + "/" + file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (int i = 0; i < Chess.CHESS; ++i) {
                for (int j = 0; j < Chess.CHESS; ++j) {
                    out.writeObject(squares[i][j]);
                }
            }
            fileOut.close();
            out.close();
            System.out.println("Serialized data is saved as chess.gam");
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("Failed to save data.");
        }
    }

    /**
     * <p>
     * Centers JFrame.
     * </p>
     */
    private void centre() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int i1 = (int) Math.min(dimension.width * 0.75, dimension.height * 0.75);
        Rectangle rectangle = new Rectangle();
        rectangle.width = i1;
        rectangle.height = i1;
        rectangle.x = (dimension.width - i1) / 2;
        rectangle.y = (dimension.height - i1) / 2;
        this.setBounds(rectangle);
    }

    public static Square getSquare(int row, int col) {
        return squares[row][col];
    }

}
