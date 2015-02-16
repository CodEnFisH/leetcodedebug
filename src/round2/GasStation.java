package round2;

/**
 * Created by codefish on 1/24/15.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        for(int i = 0; i < n; i++) diff[i] = gas[i] - cost[i];
        int sum = diff[0], p = 0, q = 0;
        while(true){
            if(sum >= 0) {
                q = q == n - 1 ? 0 : q +1;
                sum += diff[q];
            } else {
                p = p == 0 ? n - 1 : p - 1;
                sum += diff[p];
            }
            if(p == (q + 1) % n){
                if(sum >= 0) return p;
                else return -1;
            }
        }
    }
}
