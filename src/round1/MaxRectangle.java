package round1;
import java.util.*;

/**
 * Created by codefish on 1/9/15.
 */
public class MaxRectangle {
    class Bar{
        int h, idx;
        public Bar(int h, int idx){
            this.h = h;
            this.idx = idx;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] width = new int[m][n];
        for(int i = 0; i < m; i++){
            int j = 0;
            while(true){
                int cnt = 0;
                while(j < n && matrix[i][j] == '1'){
                    j++;
                    cnt++;
                }
                for(int k = 1; k <= cnt; k++){
                    width[i][j-k] = k;
                }
                if(j == n){
                    break;
                }
                j++;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                System.out.print(" " + width[i][j]);
            System.out.println();
        }

        int max = -1;
        int[] topMost = new int[m], bottomMost = new int[m];
        for(int j = 0; j < n; j++){
            Arrays.fill(topMost, 0);
            Arrays.fill(bottomMost, 0);
            Stack<Bar> s = new Stack<Bar>();
            for(int i = 0; i < m; i++){
                while(!s.isEmpty() && s.peek().h >= width[i][j]) s.pop();
                if(s.isEmpty()){
                    topMost[i] = -1;
                } else {
                    topMost[i] = s.peek().idx;
                }
                s.push(new Bar(i, width[i][j]));
            }
            s = new Stack<Bar>();
            for(int i = m-1; i >= 0; i--){
                while(!s.isEmpty() && s.peek().h >= width[i][j]) s.pop();
                if(s.isEmpty()){
                    bottomMost[i] = -1;
                } else {
                    bottomMost[i] = s.peek().idx;
                }
                s.push(new Bar(i, width[i][j]));
            }
            for(int i = 0; i < m; i++){
                System.out.print(" " + topMost[i]);
            }
            System.out.println();
            for(int i = 0; i < m; i++){
                System.out.print(" " + bottomMost[i]);
            }
            System.out.println();
            for(int i = 0; i < m; i++){
                int uidx = topMost[i] == -1 ? 0 : topMost[i]+1;
                int bidx = bottomMost[i] == -1 ? m-1 : bottomMost[i]-1;

                System.out.println("top " + uidx + " down " + bidx);
                System.out.println(width[i][j]*(bidx-uidx+1));

                max = Math.max(max, width[i][j]*(bidx-uidx+1));
            }
        }
        return max;
    }
}