package round3;

/**
 * Created by codefish on 2/1/15.
 */
public class ReverseInt {
    public int reverse(int x) {
        int sum = 0;
        boolean isPositive = x > 0;
        while(x != 0) {
            int d = x % 10;
            if(isPositive) if(sum > (Integer.MAX_VALUE - d) / 10) return 0;
            else if(sum < (Integer.MIN_VALUE - d) / 10) return 0;
            sum = sum * 10 + d;
            x /= 10;
        }
        return sum;
    }
}

