package round2;

/**
 * Created by codefish on 1/15/15.
 */
import java.util.*;
public class MaxConsecutive {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> numToLeft = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> numToRight = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i = 0; i < num.length; i++){
            Integer left = numToLeft.get(num[i]);
            if(left != null) continue;
            Integer nbLeft = numToLeft.get(num[i] - 1);
            Integer nbRight = numToRight.get(num[i] + 1);
            if(nbLeft != null && nbRight != null) {
                numToLeft.put(num[i], nbLeft);
                numToRight.put(num[i], nbRight);
                numToLeft.put(nbRight, nbLeft);
                numToLeft.put(nbLeft, nbRight);
                max = Math.max(max, nbRight - nbLeft + 1);
            } else if(nbLeft != null){
                numToLeft.put(num[i], nbLeft);
                numToRight.put(num[i], num[i]);
                numToRight.put(nbLeft, num[i]);
                max = Math.max(max, num[i] - nbLeft + 1);
            } else if(nbRight != null) {
                numToRight.put(num[i], nbRight);
                numToLeft.put(num[i], num[i]);
                numToLeft.put(nbRight, num[i]);
                max = Math.max(max, nbRight - num[i] + 1);
            } else {
                numToRight.put(num[i], num[i]);
                numToLeft.put(num[i], num[i]);
                max = Math.max(max, 1);
            }
        }
        return max;
    }
}