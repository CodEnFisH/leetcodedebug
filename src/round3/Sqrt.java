package round3;

/**
 * Created by codefish on 1/27/15.
 */
public class Sqrt {

    public int sqrt(int x) {
        int l = 0, r = x;
        while(l < r){
            int m = l + (r - l) >> 1;
            if(m == l) break;
            int tmp = x / m;
            if(m < tmp) l = m;
            else if(m > tmp) r = m;
            else return m;
        }
        if(r * r > x) return l;
        return r;
    }
}
