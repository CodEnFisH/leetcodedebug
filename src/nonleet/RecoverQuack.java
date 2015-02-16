package nonleet;

import java.util.HashMap;

/**
 * Created by codefish on 2/15/15.
 */
public class RecoverQuack {
    public int[] recoverQuack(Quack<Integer> quack){
        int i = 0, j = quack.size() - 1, ret[] = new int[quack.size()];
        while(!quack.isEmpty()){
            int next = quack.pop();
            System.out.println("pop " + next);
            int hot = quack.isEmpty() ? Integer.MIN_VALUE : quack.peek();
            if(hot < next) ret[j--] = next;
            else ret[i++] = next;
        }
        return ret;
    }
    public int[] recoverWithDuplicate(Quack<Integer> quack){
        int i = 0, j = quack.size() - 1, ret[] = new int[quack.size()];
        HashMap<Integer, Integer> intToCnt = new HashMap<Integer, Integer>();
        while(!quack.isEmpty()){
            int next = quack.pop();
            System.out.println("pop " + next);
            int hot = quack.isEmpty() ? Integer.MIN_VALUE : quack.peek();
            if(hot < next) {
                int cnt = intToCnt.containsKey(next) ? intToCnt.get(next) + 1 : 1;
                while(cnt-- > 0) ret[j--] = next;
                intToCnt.remove(next);
            }
            else if(hot == next){
                Integer cnt = intToCnt.containsKey(next)? intToCnt.get(next) : 0;
                intToCnt.put(next, cnt + 1);
            }
            else {
                int cnt = intToCnt.containsKey(next) ? intToCnt.get(next) + 1 : 1;
                while(cnt-- > 0) ret[i++] = next;
                intToCnt.remove(next);
            }
        }
        return ret;
    }
}
