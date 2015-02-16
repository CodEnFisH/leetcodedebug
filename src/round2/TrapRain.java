package round2;

/**
 * Created by codefish on 1/13/15.
 */
import java.util.*;
public class TrapRain {
    public int trap(int[] A) {
        int n = A.length;
        int[] a = A;
        int[] nearestLargerRight = new int[n], nearestLargerLeft = new int[n];
        Stack<Integer> s = new Stack<Integer>(), idx = new Stack<Integer>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() < a[i]){
                s.pop();
                idx.pop();
            }
            if(s.isEmpty()){
                nearestLargerRight[i] = -1;
            } else {
                nearestLargerRight[i] = idx.peek();
            }
            s.push(a[i]);
            idx.push(i);
        }
        s.clear();
        idx.clear();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && s.peek() <= a[i]){
                s.pop();
                idx.pop();
            }
            if(s.isEmpty()){
                nearestLargerLeft[i] = -1;
            } else {
                nearestLargerLeft[i] = idx.peek();
            }
            s.push(a[i]);
            idx.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(" " + nearestLargerRight[i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(" " + nearestLargerLeft[i]);
        }
        System.out.println();

        int sum = 0;
        for(int i = 0, j = n-1; i < j;){
            if(a[i] <= a[j]) {
                if(nearestLargerRight[i] != -1) {
                    for(int p = i; p < j && p < nearestLargerRight[i]; p++){
                        sum += (a[i]-a[p]);
                    }
                    i = nearestLargerRight[i];
                } else {
                    i++;
                }
            } else {
                if(nearestLargerLeft[j] != -1){
                    for(int p = j; p > i && p > nearestLargerLeft[i]; p--){
                        sum += (a[j]-a[p]);
                    }
                    j = nearestLargerLeft[j];
                } else {
                    j--;
                }
            }
        }
        return sum;
    }
}
