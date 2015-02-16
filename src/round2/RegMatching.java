package round2;

/**
 * Created by codefish on 1/22/15.
 */
public class RegMatching {
    int m, n;
    public boolean isMatch(String s, String p) {
        char[] a = s.toCharArray(), b = p.toCharArray();
        m = a.length;
        n = b.length;
        return match(a, 0, b, 0);
    }
    public boolean match(char[] a, int i, char[]b, int j){
        if(j == n) return i == m;
        if(j + 1 < n && b[j+1] == '*'){
            int k = i;
            while(k < m && (b[j] == '.' || a[k] == b[j])){
                if(match(a, k + 1, b, j + 2)) return true;
                k++;
            }
            return match(a, i, b, j + 2);
        } else {
            if(i != m && (b[j] == '.' || a[i] == b[j])){
                return match(a, i + 1, b, j + 1);
            }
        }
        return false;
    }
}