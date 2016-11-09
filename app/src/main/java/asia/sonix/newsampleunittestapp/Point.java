package asia.sonix.newsampleunittestapp;

/**
 * Created by steshima on 2016/11/04.
 */
public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveX(int x) {
        return new Point(this.x + x, this.y);
    }

    public Point moveY(int y) {
        return new Point(this.x, this.y + y);
    }
}
