import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper{

    public ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Boolean>> flags = new ArrayList<ArrayList<Boolean>>();

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
                System.out.print(flag || gameOver ? board.get(i).get(j) + " ": "X" + " ");
            }
            System.out.println();
        }
    }
    
    
}
