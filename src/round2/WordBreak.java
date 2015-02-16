package round2;

/**
 * Created by codefish on 1/25/15.
 */
import java.util.*;
public class WordBreak {
    int maxLen = Integer.MIN_VALUE;
    int len;
    public List<String> wordBreak(String s, Set<String> dict) {
        len = s.length();
        for(String w: dict){
            maxLen = Math.max(maxLen, w.length());
        }
        ArrayList<LinkedList<String>> f = new ArrayList<LinkedList<String>>();
        for(int i = 0; i < s.length(); i++) f.add(null);
        return dp(s, dict, f);
    }
    public LinkedList<String> dp(String s, Set<String> dict, ArrayList<LinkedList<String>> f){
        if(s.equals("")){
            LinkedList<String> ret = new LinkedList<String>();
            ret.add("");
            return ret;
        }
        if(f.get(len - s.length()) != null) return f.get(len - s.length());
        int max = Math.min(s.length(), maxLen);
        LinkedList<String> sentences = new LinkedList<String>();
        for(int i = 1; i <= max; i++){
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)){
                LinkedList<String> suffixResult = dp(s.substring(i), dict, f);
                for(String suffix: suffixResult){
                    if(!suffix.equals("")) sentences.add(prefix + " " + suffix);
                    else sentences.add(prefix);
                }
            }
        }
        f.set(len - s.length(), sentences);
        return sentences;
    }
}
