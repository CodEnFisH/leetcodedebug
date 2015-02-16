package round2;

/**
 * Created by codefish on 1/14/15.
 */
public class MinWindow {
    public String minWindow(String S, String T) {
        if (T.length() == 0) return "";
        int[] status = new int[256];
        int[] dict = new int[256];
        char[] s = S.toCharArray(), t = T.toCharArray();
        for (int i = 0; i < T.length(); i++) {
            dict[(int) s[i]]++;
        }
        int min = Integer.MAX_VALUE, i = 0, j = 0;
        status[(int) s[0]]++;
        String ret = "";
        while (i <= j && j < S.length()) {
            //[i,j] is the current status
            if (hasAll(status, dict)) {
                // first check if min should be updated
                if (min > j - i + 1) {
                    min = j - i + 1;
                    ret = S.substring(i, j + 1);
                }
                // consider shrink one more char on the left
                if (i >= j) return ret;
                if (dict[(int) s[i]] > 0) {
                    status[(int) s[i]]--;
                }
                i++;
            } else {
                // consider next char on the right
                j++;
                if (j >= s.length) break;
                if (dict[(int) s[j]] > 0) {
                    status[(int) s[j]]++;
                }
            }
        }
        return ret;
    }
    public boolean hasAll(int[] status, int[] dict){
        for(int i = 0; i < status.length; i++){
            if(status[i] < dict[i]) return false;
        }
        return true;
    }
}
