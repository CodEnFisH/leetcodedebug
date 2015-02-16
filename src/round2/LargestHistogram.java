package round2;

/**
 * Created by codefish on 1/15/15.
 */
import java.util.*;
public class LargestHistogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>(), idx = new Stack<Integer>();
        int n = height.length;
        int[] nearestLeft = new int[n], nearestRight = new int[n];
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && s.peek() >= height[i]) {
                s.pop();
                idx.pop();
            }
            if(s.isEmpty()) nearestLeft[i] = -1;
            else {
                nearestLeft[i] = idx.peek();
            }
            s.push(height[i]);
            idx.push(i);
        }
        s.clear();
        idx.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() >= height[i]) {
                s.pop();
                idx.pop();
            }
            if(s.isEmpty()) nearestRight[i] = n;
            else {
                nearestRight[i] = idx.peek();
            }
            s.push(height[i]);
            idx.push(i);
        }
        int max = -1;
        for(int i = 0; i < n; i++){
            int left = nearestLeft[i] + 1, right = nearestRight[i] - 1;
            max = Math.max(height[i] * (right - left + 1), max);
        }
        System.out.println(max);
        return max;
    }
}