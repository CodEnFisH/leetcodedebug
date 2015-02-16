package round2;

/**
 * Created by codefish on 1/25/15.
 */
import java.util.*;
public class Division {
    // idea: simulate the division.
    // corner case: overflow (r)?, negative, 0
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = (numerator >= 0 && denominator >= 0 || numerator <= 0 && denominator <= 0) ?
                "": "-";
        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        long integer = num / denom;
        long r = num % denom;
        if(r == 0) return sign + Long.toString(integer);
        StringBuffer buf = new StringBuffer();
        HashMap<Long, Integer> repeatPosition = new HashMap<Long, Integer>();
        repeatPosition.put(r, -1);
        while(true){
            r *= 10;
            if(r > denominator) {
                long d = r / denominator;
                r = r % denominator;
                buf.append(Math.abs(d));
                if(repeatPosition.containsKey(r)) {
                    return sign + Long.toString(integer) + "." +
                            buf.substring(0, repeatPosition.get(r) + 1) + "(" +
                            buf.substring(repeatPosition.get(r) + 1) + ")";
                } else if(r == 0){
                    return sign + Long.toString(integer) + "." + buf.toString();
                } else {
                    repeatPosition.put(r, buf.length() - 1);
                }
            } else {
                buf.append(0);
                repeatPosition.put(r, buf.length() - 1);
            }
        }
    }
}
