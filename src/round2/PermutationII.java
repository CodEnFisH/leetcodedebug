package round2;

/**
 * Created by codefish on 1/25/15.
 */
import java.util.*;
public class PermutationII {
    // note: to avoid duplication, we need sort the array first, and do not use same elem twice at the
    // same position
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        boolean[] used = new boolean[num.length];
        LinkedList<Integer> status = new LinkedList<Integer>();
        Arrays.sort(num);
        search(num, used, ret, status);
        return ret;
    }
    public void search(int[] num, boolean[] used, List<List<Integer>> ret, LinkedList<Integer> status){
        if(status.size() == num.length){
            ret.add(new LinkedList<Integer>(status));
            return;
        }
        for(int i = 0; i < num.length; ){
            if(!used[i]){
                status.add(num[i]);
                used[i] = true;
                search(num, used, ret, status);
                used[i] = false;
                status.removeLast();
                int pos = i++;
                while(i < num.length && num[i] == num[i-1]) i++;
            } else i++;
        }
    }
}