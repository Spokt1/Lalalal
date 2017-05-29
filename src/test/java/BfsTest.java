import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by slava on 11.11.2016.
 */
import projectBFS.Bfs;

public class BfsTest {
    private Bfs bfs;
    @Before
    public void init(){
        bfs = new Bfs();
    }
    @Test
    public void relateGraph() throws Exception {
        assertEquals("135",bfs.run(1,5));
    }
    @Test
    public void searchPointEqualZero() {
        assertEquals("",bfs.run(1,0));
    }
    @Test(expected = Exception.class)
    public void startPointEqualZero(){
        assertEquals("", bfs.run(0,1));
    }
    @Test(expected = Exception.class)
    public void startPointNegative(){
        assertEquals("",bfs.run(-1,2));
    }
    @Test
    public void searchPointNegative(){
        assertEquals("",bfs.run(1,-1));
    }
    @Test(expected = Exception.class)
    public void emptyGraph(){
        bfs.setMatrix(null);
        assertEquals("", bfs.run(1,3));
    }
    @Test
    public void coupleVertex(){
        int[][] a = {
                {0,1},
                {1,0}
        };
        bfs.setMatrix(a);
        assertEquals("12", bfs.run(1,2));
    }
    @Test
    public void unrelateGraphWithWay(){
        int[][] a = {
                {0,1,1,0,0,1},
                {1,0,1,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,1,1},
                {0,0,0,1,0,1},
                {1,0,0,1,1,0}
        };
        bfs.setMatrix(a);
        assertEquals("16",bfs.run(1,6));
    }
    @Test
    public void unrelateGraphWithoutWay(){
        int[][] a = {
                {0,1,1,0,0,0},
                {1,0,1,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,1,1},
                {0,0,0,1,0,1},
                {0,0,0,1,1,0}
        };
        bfs.setMatrix(a);
        assertEquals("",bfs.run(1,5));
    }
}