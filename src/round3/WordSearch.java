package round3;

import java.util.Arrays;

/**
 * Created by codefish on 2/7/15.
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                for(boolean[] arr: visited) Arrays.fill(arr, false);
                if(dfs(i, j, word, 0, board, visited))
                    return true;
            }
        return false;
    }
    public boolean dfs(int i, int j, String s, int pos, char[][] board, boolean[][] visited){
        visited[i][j] = true;
        if(s.charAt(pos) == board[i][j]){
            if(s.length() - 1 ==  pos) return true;
            if( i + 1 < board.length && !visited[i+1][j] && dfs(i + 1, j, s, pos + 1, board, visited) ||
                    i - 1 >= 0 && !visited[i-1][j] && dfs(i - 1, j, s, pos + 1, board, visited) ||
                    j + 1 < board[0].length && !visited[i][j+1] && dfs(i, j + 1, s, pos + 1, board, visited) ||
                    j - 1 >= 0 && !visited[i][j-1] && dfs(i, j - 1, s, pos + 1, board, visited) )
                return true;
        }
        return false;
    }
}
