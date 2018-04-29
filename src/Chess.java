import java.io.Serializable;

public class Chess implements Serializable {
    /**
     *  Serial id.
     */
    private static final long serialVersionUID = 7542228648517926288L;
    /**
     * <p>
     * Constructs a board.
     * </p>
     */
    private Board board;
    /**
     * <p>
     * Colums and Row amount.
     * </p>
     */
    public static final int CHESS = 8;

    /**
     * <p>
     * Initializes game.
     * </p>
     */
    public Chess() {
        initGame();
    }

    /**
     * <p>
     * Creates board.
     * </p>
     */
    public void initGame() {
        board = new Board("Daniel's Chess Game");
    }

    /**
     * <p>
     * Main method.
     * </p>
     * 
     * @param args
     *            arguments
     */
    public static void main(String[] args) {
        Chess myGame = new Chess();

    }

}
