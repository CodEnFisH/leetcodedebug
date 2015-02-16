package nonleet;

import java.util.LinkedList;

public class FlowWaterToSea {
    public class Point {
        public int x, y;
        public Point(int x, int y){
            this.x = x; this.y = y;
        }
    }
    public LinkedList<Point> findAllPoints(int[][] height){
        int m = height.length, n = height[0].length;
        boolean[][] reachable1 = new boolean[m][n], reachable2 = new boolean[m][n];
        for(int i = 0; i < m - 1; i++) reachable1[i][0] = true;
        for(int j = 0; j < n; j++) reachable1[0][j] = true;
        for(int i = 1; i < m; i++) reachable1[i][n-1] = true;
        for(int j = 0; j < n; j++) reachable1[m-1][j] = true;
        for(int i = 0; i < m - 1; i++) reachable2[i][0] = true;
        for(int j = 0; j < n; j++) reachable2[0][j] = true;
        for(int i = 1; i < m; i++) reachable2[i][n-1] = true;
        for(int j = 0; j < n; j++) reachable2[m-1][j] = true;

        for(int i = 0; i < m - 1; i++) dfs(i, 0, height, reachable1);
        for(int j = 0; j < n; j++) dfs(0, j, height, reachable1);

        for(int i = 1; i < m; i++) dfs(i, n - 1, height, reachable2);
        for(int j = 0; j < n; j++) dfs(m - 1, j, height, reachable2);
        LinkedList<Point> ret = new LinkedList<Point>();
        for(int i = 1; i < m - 1; i++)
            for(int j = 1; j < n - 1; j++)
                if(reachable1[i][j] && reachable2[i][j]) ret.add(new Point(i,j));
        return ret;
    }
    public void dfs(int i, int j, int[][] height, boolean[][] reachable){
        reachable[i][j] = true;
        if(i + 1 < height.length && !reachable[i+1][j] &&
                height[i+1][j] >= height[i][j]) dfs(i + 1, j, height, reachable);
        if(j + 1 < height[0].length && !reachable[i][j+1] &&
                height[i][j+1] >= height[i][j]) dfs(i, j + 1, height, reachable);
        if(i - 1 >= 0 && !reachable[i-1][j] &&
                height[i-1][j] >= height[i][j]) dfs(i - 1, j, height, reachable);
        if(j - 1 >= 0 && !reachable[i][j-1] &&
                height[i][j-1] >= height[i][j]) dfs(i, j - 1, height, reachable);
    }
}
