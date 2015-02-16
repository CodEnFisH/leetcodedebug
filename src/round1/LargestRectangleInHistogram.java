package round1;

/**
 * Created by codefish on 1/9/15.
 */
import java.util.*;
public class LargestRectangleInHistogram {
    class Bar{
        int h, idx;
        public Bar(int h, int idx){
            this.h = h;
            this.idx = idx;
        }
    }
    public int largestRectangleArea(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
        int[] nearestSmallerOnLeft = new int[n], nearestSmallerOnRight = new int[n];
        Stack<Bar> s = new Stack<Bar>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && s.peek().h >= height[i]) s.pop();
            if(s.isEmpty()) nearestSmallerOnLeft[i] = -1;
            else nearestSmallerOnLeft[i] = s.peek().idx;
            s.push(new Bar(height[i], i));
        }
        s = new Stack<Bar>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && s.peek().h >= height[i]) s.pop();
            if(s.isEmpty()) nearestSmallerOnRight[i] = -1;
            else nearestSmallerOnRight[i] = s.peek().idx;
            s.push(new Bar(height[i], i));
        }
        for(int i = 0; i < n; i++)
            System.out.print(" " + nearestSmallerOnLeft[i]);
        System.out.println();
        for(int i = 0; i < n; i++)
            System.out.print("" + nearestSmallerOnRight[i]);
        System.out.println();
        int max = -1;
        for(int i = 0; i < n; i++){
            int lidx = nearestSmallerOnLeft[i] == -1 ? 0 : nearestSmallerOnLeft[i]+1;
            int ridx = nearestSmallerOnRight[i] == -1 ? n-1 : nearestSmallerOnRight[i]-1;
            max = Math.max(max, (ridx-lidx+1)*height[i]);
        }
        System.out.println(max);
        return max;
    }
}