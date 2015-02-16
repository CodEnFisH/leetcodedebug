package nonleet;

/**
 * Created by codefish on 2/6/15.
 */
public class DivideInt {
    public int divide(int dividend, int divisor) {
        // overflow cases: divisor == 0, dividend = MIN && divisor == -1
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == Integer.MIN_VALUE) return 0;
        return div(dividend, divisor)[0];
    }
    // guarantee b != Integer.MIN_VALUE
    public int[] div(int a, int b){
        int[] ret = new int[2];
        if( a == b || a == -b) {
            ret[0] = a == b ? 1 : -1; ret[1] = 0;
            return ret;
        } else if( b > 0 && a < b && a > -b ||
                b < 0 && a > b && a < -b) {
            ret[0] = 0; ret[1] = a;
            return ret;
        }
        int m = a > 0 ? a >> 1 : (a + 1) >> 1;
        int r = a - m - m;
        int[] res = div(m, b);
        int q = res[0] + res[0], residual = res[1] + res[1] + r;
        if(b > 0 && residual > b) {
            if(a > 0) q++;
            else q--;
            residual -= b;
        } else if(b < 0 && residual < b){
            if(a > 0) q--;
            else q++;
            residual -= b;
        }
        ret[0] = q; ret[1] = residual;
        return ret;
    }
}
