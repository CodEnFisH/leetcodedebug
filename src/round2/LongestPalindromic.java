package round2;

/**
 * Created by codefish on 1/20/15.
 */
import java.util.*;
public class LongestPalindromic {
    int[][] f;
    String longest = "";
    public String longestPalindrome(String s) {
        if(s.length() == 0) return longest;
        f = new int[s.length()][s.length()];
        for(int i = 0; i < f.length; i++) Arrays.fill(f[i], -1);
        for(int i = 0; i < s.length(); i++) f[i][i] = 1;
        for(int k = 2; k <= s.length(); k++){
            int start = -1, end = -1;
            for(int i = 0; i <= s.length() - k; i++){
                int j = i + k - 1;
                if(k == 2){
                    if(s.charAt(i) == s.charAt(j)){
                        start = i; end = j;
                        f[i][j] = 1;
                    } else f[i][j] = 0;
                } else {
                    if(s.charAt(i) == s.charAt(j) && f[i+1][j-1] == 1){
                        start = i; end = j;
                        f[i][j] = 1;
                    } else f[i][j] = 0;
                }
            }
            if(start != -1) longest = s.substring(start, end + 1);
            else break;
        }
        return longest;
    }
}