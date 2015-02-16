package nonleet;

/**
 * Created by codefish on 2/14/15.
 */
public class SodukuSolver {
    boolean[][] rowStatus = new boolean[9][10];
    boolean[][] colStatus = new boolean[9][10];
    boolean[][] boxStatus = new boolean[9][10];
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.')
                    rowStatus[i][board[i][j]-'0'] =
                            colStatus[j][board[i][j]-'0'] =
                                    boxStatus[(i/3)*3+j/3][board[i][j]-'0'] = true;
            }
        }
        search(board, 0, 0);
    }
    public boolean search(char[][] board, int i, int j){
        if(j == 9){
            j = 0; i++;
        }
        if(i == 9) return true;
        if(board[i][j] == '.'){
            for(int num = 1; num <= 9; num++){
                if(!rowStatus[i][num] && !colStatus[j][num] && !boxStatus[(i/3)*3+j/3][num]){
                    rowStatus[i][num] = colStatus[j][num] = boxStatus[(i/3)*3+j/3][num] = true;
                    board[i][j] = (char)('0' + num);
                    if(search(board, i, j + 1)) break;
                    rowStatus[i][num] = colStatus[j][num] = boxStatus[(i/3)*3+j/3][num] = false;
                }
            }
            board[i][j] = '.';
            return true;
        } else return search(board, i, j + 1);
    }
}
