package round3;

import java.util.Arrays;

/**
 * Created by codefish on 2/15/15.
 */
public class WildCard {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length(), lowestTrue = -1;
        if(p.equals("")) return s.equals("");
        if(s.equals("")) {
            for(int i = 0; i < n; i++) if(p.charAt(i) != '*') return false;
            return true;
        }
        boolean[] f = new boolean[m+1], g = new boolean[m+1];
        if(p.charAt(n - 1) == '*'){
            Arrays.fill(f, true);
            lowestTrue = m - 1;
        } else if(p.charAt(n - 1) == '?' || p.charAt(n - 1) == s.charAt(m - 1)) {
            f[m-1] = true;
            lowestTrue = m - 1;
        }
        if(lowestTrue == -1) return false;
        for(int j = n - 2; j >= 0; j--){
            boolean hasMatch = false;
            int newLowest = -1;
            for(int i = m - 1; i >= 0; i--){
                if(p.charAt(j) == '*') {
                    if(i <= lowestTrue) g[i] = true;
                    else g[i] = false;
                } else {
                    if(p.charAt(j) == '?') g[i] = f[i+1];
                    else {
                        if(p.charAt(j) == s.charAt(i) && f[i+1]) g[i] = true;
                        else g[i] = false;
                    }
                }
                if(g[i] && newLowest == -1) newLowest = i;
            }
            if(newLowest == -1) return false;
            else {// rolling array
                boolean[] tmp = f;
                f = g;
                g = tmp;
                lowestTrue = newLowest;
            }
        }
        return f[0];
    }
}
