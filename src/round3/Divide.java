package round3;

/**
 * Created by codefish on 2/14/15.
 */
public class Divide {
    public int divide(int x, int y) {
        if(x == Integer.MIN_VALUE && y == -1 || y == 0) return Integer.MAX_VALUE;
        long a = Math.abs((long)x), b = Math.abs((long)y);
        div(a, b);
        boolean positive = x > 0 && y > 0 || x < 0 && y < 0;
        if(positive) return (int)k;
        else return (int)(-k);
    }
    long k, r;
    // abs
    public void div(long a, long b){
        if(b == 1) {
            k = a; r = 0;
            return;
        } else if(a < b) {
            k = 0; r = a;
            return;
        } else if (a == b) {
            k = 1; r = 0;
            return;
        }
        div(a >> 1, b);
        k = k << 1;
        r = r + r + a - ((a >> 1) << 1);
        if(r >= b){
            k += 1;
            r -= b;
        }
    }
}
