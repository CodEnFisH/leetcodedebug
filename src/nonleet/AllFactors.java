package nonleet;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codefish on 2/12/15.
 */
public class AllFactors {
    public List<Integer> allFactor(int[] primes){
        List<Integer> ret = new LinkedList<Integer>();
        dfs(primes, 0, 1, ret);
        return ret;
    }
    public void dfs(int[] p, int pos, int curr, List<Integer> ret){
        if(p.length == pos) {
            ret.add(curr);
            return;
        }
        dfs(p, pos + 1, curr, ret);
        dfs(p, pos + 1, curr * p[pos], ret);
    }
}
