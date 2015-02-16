package nonleet;

/**
 * Created by codefish on 2/10/15.
 */
public class MaxInSemiSorted {
    public int findMax(int[] num){
        int l = 0, r = num.length - 1, m;
        while(l < r){
            m = l + (r - l) / 2;
            if(num[m] <= num[m+1]) l = m + 1;
            else if(m == l || num[m-1] < num[m]) return num[m];
            else r = m - 1;
        }
        return num[l];
    }
}
