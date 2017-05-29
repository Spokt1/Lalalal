import org.junit.Before;
import org.junit.Test;
import projectBFS.NewBfs;
import projectBFS.Route;
import projectBFS.TypeOutput;

import static org.junit.Assert.*;

/**
 * Created by slava on 21.05.2017.
 */
public class NewBfsTest {
    private NewBfs bfs;

    @Before
    public void init() {
        bfs = new NewBfs();
    }

    @Test
    public void relateGraph() throws Exception {
        int[][] a = {
                {0, 0, 1, 3},
                {1, 2, 0, 1},
                {1, 2, 0, 0},
                {0, 1, 0, 0}
        };
        bfs.setMatrix(a);
        Route r = new Route();
        r.setRoute("1-3-2");
        r.setWeight(3);
        assertEquals(r.toString(), bfs.run(1, 2, TypeOutput.MINROUTE));
    }

    @Test
    public void searchPointEqualZero() {
        assertEquals("invalid input values", bfs.run(1, 0, TypeOutput.MINROUTE));
    }

    @Test
    public void startPointEqualZero() {
        assertEquals("invalid input values", bfs.run(0, 1, TypeOutput.MINROUTE));
    }

    @Test
    public void startPointNegative() {
        assertEquals("invalid input values", bfs.run(-1, 2, TypeOutput.MINROUTE));
    }

    @Test
    public void searchPointNegative() {
        assertEquals("invalid input values", bfs.run(2, -2, TypeOutput.MINROUTE));
    }

    @Test(expected = Exception.class)
    public void emptyGraph() {
        bfs.setMatrix(null);
        assertEquals("", bfs.run(1, 3, TypeOutput.MINROUTE));
    }

    @Test
    public void coupleVertex() {
        int[][] a = {
                {0, 1},
                {1, 0}
        };
        bfs.setMatrix(a);
        Route r = new Route();
        r.setRoute("1-2");
        r.setWeight(1);
        assertEquals(r.toString(), bfs.run(1, 2, TypeOutput.MINROUTE));
    }

    @Test
    public void unrelateGraphWithWay() {
        int[][] a = {
                {0, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 0}
        };
        bfs.setMatrix(a);
        Route r = new Route();
        r.setRoute("1-6");
        r.setWeight(1);
        assertEquals(r.toString(), bfs.run(1, 6, TypeOutput.MINROUTE));
    }

    @Test
    public void unrelateGraphWithoutWay() {
        int[][] a = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 0}
        };
        bfs.setMatrix(a);
        assertEquals("", bfs.run(1, 5, TypeOutput.MINROUTE));
    }

    @Test
    public void multipleAnswers(){
        int[][] a = {
                {0, 0, 1, 3},
                {1, 2, 0, 1},
                {1, 2, 0, 0},
                {0, 1, 0, 0}
        };
        bfs.setMatrix(a);
        String ans = "";
        Route r = new Route();
        r.setRoute("1-3-2");
        r.setWeight(3);
        ans += r.toString() + "\n";
        r.setRoute("1-4-2");
        r.setWeight(4);
        ans += r.toString() + "\n";
        assertEquals(ans, bfs.run(1, 2, TypeOutput.PRINTALLROUTES));
    }

    @Test
    public void notASquareMatrix(){
        int[][] a = {
                {0, 0, 1, 3},
                {1, 2, 0},
                {1, 2, 0, 0},
                {0, 1, 0, 0}
        };
        bfs.setMatrix(a);
        assertEquals("invalid size of matrix", bfs.run(1, 2, TypeOutput.PRINTALLROUTES));
    }
}