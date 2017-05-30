package projectBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by slava on 10.11.2016.
 */

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 1, 10},
                {1, 2, 0, 1},
                {1, 2, 0, 0},
                {0, 3, 0, 0}
        };
        Bfs bfs = new Bfs();
        bfs.setMatrix(matrix);
    }
}
