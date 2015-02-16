package round2;

/**
 * Created by codefish on 1/25/15.
 */
public class PerSeq {
    public String getPermutation(int n, int k) {
        int[] cnt = new int[10];
        cnt[0] = 1;
        for(int i = 1; i <= 9; i++) cnt[i] = cnt[i-1] * i;
        String ret = "";
        for(int i = n - 1; i >= 0; i--){
            ret += "1" + (k-1) / cnt[i];
            k -= cnt[i] * ((k-1)/cnt[i]);
        }
        return ret;
    }
}