package nonleet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * M is room, 0 is police, -1 is block
 * M,   M,   0
 * -1,  0, -1
 * M,   M,  M
 */

public class ClosestPolices {
    class Coord{
        int x, y;
        Coord(int x, int y){
            this.x = x; this.y = y;
        }
    }
    public void findCloestPolice(int[][] map){
        Queue<Coord> queue = new LinkedList<Coord>();
        int m = map.length, n = map[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0){
                    visited[i][j] = true;
                    queue.add(new Coord(i, j));
                }
            }
        }
        int[][] direction = { {0,-1}, {1,0}, {0,1}, {-1,0} };
        while(!queue.isEmpty()){
            Coord next = queue.remove();
            for(int d = 0; d < 4; d++){
                int x = next.x + direction[d][0];
                int y = next.y + direction[d][1];
                if(0 <= x && x < m && 0 <= y && y < n){
                    if(map[x][y] == Integer.MAX_VALUE && !visited[x][y]){
                        map[x][y] = map[next.x][next.y] + 1;
                        visited[x][y] = true;
                        queue.add(new Coord(x, y));
                    }
                }
            }
        }
    }
}
