package round3;

import java.util.HashMap;

/**
 * Created by codefish on 2/10/15.
 */
public class LongestConseq {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> idxToLen = new HashMap<Integer, Integer>();
        int ret = 0;
        for(int i: num){
            if(idxToLen.containsKey(i)) continue;
            int right = idxToLen.containsKey(i + 1) ? idxToLen.get(i + 1) : 0;
            int left = idxToLen.containsKey(i - 1) ? idxToLen.get(i - 1) : 0;
            if(right != 0 && left == 0) {
                idxToLen.put(i + right, right + 1);
                idxToLen.put(i, right + 1);
            } else if(left != 0 && right == 0) {
                idxToLen.put(i - left,  left + 1);
                idxToLen.put(i, left + 1);
            } else if(left != 0 && right != 0){
                idxToLen.put(i - left, right + left + 1);
                idxToLen.put(i + right, right + left + 1);
            } else idxToLen.put(i, 1);
            ret = Math.max(ret, right + left + 1);
        }
        return ret;
    }
}

