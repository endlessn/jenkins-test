package asia.sonix.newsampleunittestapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by steshima on 2016/11/04.
 */
public class PointTest {

    Point point;
    @Before
    public void setUp() throws Exception {
        point = new Point(5, 10);
    }

    @Test
    public void testGetX() throws Exception {

    }

    @Test
    public void testGetY() throws Exception {

    }

    @Test
    public void testMoveX() throws Exception {

    }

    @Test
    public void testMoveY() throws Exception {

    }

    @Test
    public void testX座標にマイナス移動して0になる() throws Exception {
        Point newPoint = point.moveX(-5);
        assertEquals(0, newPoint.x);
    }
}