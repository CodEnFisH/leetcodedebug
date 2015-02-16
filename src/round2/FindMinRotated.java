package round2;

/**
 * Created by codefish on 1/10/15.
 */
public class FindMinRotated {
    public int findMin(int[] num) {
        int[] a = num;
        int n = num.length;
        int l = 0, r = n-1, m;
        while(l < r){
            m = l + (r-l) >> 1;
            if(a[m] > a[r]) {
                l = m+1;
            } else if(a[m] < a[r]) {
                r = m;
            }
        }
        return a[l];
    }
}
