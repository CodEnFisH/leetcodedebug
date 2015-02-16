package round2;

/**
 * Created by codefish on 1/20/15.
 */
import java.util.*;
public class Anagram {
    public List<String> anagrams(String[] strs) {
        int[] signature = new int[256];
        HashMap<String, List<String>> results = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            Arrays.fill(signature, 0);
            for(int j = 0; j < strs[i].length(); j++){
                signature[(int)strs[i].charAt(j)]++;
            }
            String sig = Arrays.toString(signature);
            List<String> group = results.containsKey(sig) ?
                    results.get(sig) : new LinkedList<String>();
            group.add(strs[i]);
        }
        List<String> ret = new LinkedList<String>();
        for(List<String> group: results.values()){
            if(group.size() > 1) ret.addAll(group);
        }
        return ret;
    }
}