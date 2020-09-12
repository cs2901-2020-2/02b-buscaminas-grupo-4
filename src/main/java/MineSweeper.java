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
   
}
