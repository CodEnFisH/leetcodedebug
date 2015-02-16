package round2;

/**
 * Created by codefish on 1/18/15.
 */
import java.util.*;
public class ConcationSubstring {
    public List<Integer> findSubstring(String S, String[] L) {
        char[] s = S.toCharArray();
        int n = s.length, m = L.length, l = L[0].length(), totalLen = L[0].length() * L.length;
        List<Integer> ret = new LinkedList<Integer>();
        if(n < totalLen) return ret;
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        HashMap<String, Integer> status = new HashMap<String, Integer>();
        for(int i = 0; i < m; i++){
            Integer cnt = dict.get(L[i]);
            if(cnt == null) dict.put(L[i], 1);
            else dict.put(L[i], cnt + 1);
        }
        for(int start = 0; start < l; start++){
            int i = start, j = i;
            status = new HashMap<String, Integer>(dict);
            while(i <= n - totalLen && j <= n - l){
                String nextItem = new String(s, j, l);
                Integer cntInDict = dict.get(nextItem);
                if(cntInDict == null) {
                    i = j + l;
                    j = i;
                    status = new HashMap<String, Integer>(dict);
                } else {
                    Integer cntInStatus = status.get(nextItem);
                    if(cntInStatus == null){
                        // run out of cnt, should move left bar
                        String leftMost = new String(s, i, l);
                        Integer cntLeftMost = status.get(leftMost);
                        if(cntLeftMost == 1) status.remove(leftMost);
                        else status.put(leftMost, cntLeftMost - 1); // put the leftmost word back
                        i += l;
                    } else {
                        // we can use the nextItem
                        if(cntInStatus == 1) {
                            status.remove(nextItem); // use the last cnt of the right most word
                            if(status.size() == 0) {
                                // bingo!
                                ret.add(i);
                                String leftMost = new String(s, i, l);
                                status.put(leftMost, 1);
                                i += l;
                            }
                            j += l;
                        } else {
                            status.put(nextItem, cntInStatus - 1);
                            j += l;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
