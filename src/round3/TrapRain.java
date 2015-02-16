package round3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by codefish on 1/31/15.
 */
public class TrapRain {
    public int trap(int[] A) {
        int i = 0, j = 0, n = A.length, sum = 0;
        int[] left = new int[n], right = new int[n];
        ArrayList<Integer> valueStack = new ArrayList<Integer>(), idxStack = new ArrayList<Integer>();
        while(i < n){
            while(!valueStack.isEmpty() && valueStack.get(valueStack.size() - 1) < A[i]) {
                valueStack.remove(valueStack.size() - 1);
                idxStack.remove(idxStack.size() - 1);
            }
            if(valueStack.isEmpty()) left[i] = -1;
            else left[i] = idxStack.get(idxStack.size() - 1);
            valueStack.add(A[i]);
            idxStack.add(i);
            i++;
        }
        valueStack = new ArrayList<Integer>();
        idxStack = new ArrayList<Integer>();
        i = n - 1;
        while(i >= 0){
            while(!valueStack.isEmpty() && valueStack.get(valueStack.size() - 1) < A[i]) {
                valueStack.remove(valueStack.size() - 1);
                idxStack.remove(idxStack.size() - 1);
            }
            if(valueStack.isEmpty()) right[i] = -1;
            else right[i] = idxStack.get(idxStack.size() - 1);
            valueStack.add(A[i]);
            idxStack.add(i);
            i--;
        }
        i = 0; j = n - 1;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        while(i < j){
            if(A[i] <= A[j]){
                if(right[i] == -1) break;
                else {
                    for(int k = i; k < right[i]; k++) sum += (A[i] - A[k]);
                    i = right[i];
                }
            } else {
                if(left[j] == -1) break;
                else {
                    for(int k = j; k > left[i]; k--) sum += (A[j] - A[k]);
                    j = left[j];
                }
            }
        }
        return sum;
    }
}
