package round1;


import java.util.*;

/**
 * Created by codefish on 1/6/15.
 */
public class WindowSum {
    public String minWindow(String S, String T) {
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        if(S.length() == 0) return "";
        String ret = "";
        char[] s = S.toCharArray();
        HashMap<Character, Integer> status = new HashMap<Character, Integer>();
        HashSet<Character> dict = new HashSet<Character>();
        for(int k = 0; k < T.length(); k++){
            dict.add(T.charAt(k));
        }

        for(i = 0; i < s.length; i++){
            if(dict.contains(s[i])){
                status.put(s[i], 1);
                j = i;
                break;
            }
        }
        if(status.size() == 0) return ret;
        while(true){
            if(dict.size() == status.size()){
                if(j-i < min) {
                    min = j-i;
                    ret = S.substring(i+1, j+2);
                }
                Integer cnt = status.get(s[i]);
                cnt--;
                if(cnt == 0) status.remove(s[i]);
                else {
                    status.put(s[i], cnt);
                }
                i++;
                if(i > j) break;
            } else {
                if(j == s.length - 1) break;
                j++;
                if(dict.contains(s[j])){
                    Integer cnt = status.get(s[j]);
                    if(cnt == null){
                        status.put(s[j], 1);
                    } else {
                        status.put(s[j], cnt+1);
                    }
                }
            }
        }
        return ret;
    }
}
