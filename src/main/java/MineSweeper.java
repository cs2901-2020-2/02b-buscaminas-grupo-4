import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;

public class MineSweeper {

    public ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Boolean>> flags = new ArrayList<ArrayList<Boolean>>();
    private SecureRandom randomMine = new SecureRandom();

    private int n;
    boolean gameOver = false;

    static final Logger logger = Logger.getLogger(MineSweeper.class.getName());

    public MineSweeper(int _n) {
        n = _n;
        createGrid();
        insertMines();
    }

    public MineSweeper(ArrayList<ArrayList<Integer>> newBoard) {
        board = newBoard;
    }

    public void createGrid() {
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<Integer>());
            flags.add(new ArrayList<Boolean>());
            for (int j = 0; j < n; j++) {
                board.get(i).add(j, 0);
                flags.get(i).add(j, false);
          }
        }
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = flags.get(i).get(j);
                logger.info(flag || gameOver ? board.get(i).get(j) + " ": "X" + " ");
            }
        }
    }
    
    public void insertMines() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board.get(i).add(j, this.randomMine.nextBoolean() ? 1 : 0);
            }                   
        }
    }

    public void isBomb(int x, int y){
        if (board.get(x).get(y) == 1){
            gameOver = true;
        }
    }

    public void play(int x, int y){
        flags.get(x).add(y, true);
        isBomb(x, y);
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public static void main(String[] args){
        logger.info("CS-UTEC Software Engineering I");
        Scanner in = new Scanner(System.in);
        MineSweeper game = new MineSweeper(5);
        game.printBoard();
        int x, y;
        while(!game.gameOver){
            logger.info("Ingrese la coordenada x: "); x = in.nextInt();
            logger.info("Ingrese la coordenada y: "); y = in.nextInt();
            game.play(x, y);
            game.printBoard();
        }
        logger.info("PERDISTE!!!");
        game.printBoard();
        in.close();
    }
}
