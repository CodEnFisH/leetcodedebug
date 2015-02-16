package round1;
import java.util.*;
public class Sudoku {
    boolean[][] rowStatus, colStatus, boxStatus;
    public void solveSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        rowStatus = new boolean[9][9];
        colStatus = new boolean[9][9];
        boxStatus = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            Arrays.fill(rowStatus[i], false);
            Arrays.fill(colStatus[i], false);
            Arrays.fill(boxStatus[i], false);
        }

        // init
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int digit = board[i][j]-'0';
                    rowStatus[i][digit-1] = true;
                    colStatus[j][digit-1] = true;
                    boxStatus[box(i,j)][digit-1] = true;
                }
            }
        }

        //search
        search(0,0,board);
    }

    public boolean search(int i, int j, char[][] board){
        if(i == 9) return true;
        if(board[i][j] == '.'){
            for(int k = 1; k <= 9; k++){
                if(isValid(i, j, k, board)){
                    rowStatus[i][k-1] = true;
                    colStatus[j][k-1] = true;
                    boxStatus[box(i,j)][k-1] = true;
                    board[i][j] = (char)('0'+k);
                    if(j < 8){
                        if(search(i, j+1, board)) return true;
                    } else {
                        if(search(i+1, 0, board)) return true;
                    }
                    rowStatus[i][k-1] = false;
                    colStatus[j][k-1] = false;
                    boxStatus[box(i,j)][k-1] = false;
                }
            }
            return false;
        } else {
            if(j < 8) return search(i, j+1, board);
            else return search(i+1, 0, board);
        }
    }

    public boolean isValid(int i, int j, int k, char[][] board){
        for(int r = 0; r < 9; r++){
            if(r != i && colStatus[j][k-1]) return false;
        }
        for(int c = 0; c < 9; c++){
            if(j != c && rowStatus[i][k-1]) return false;
        }
        return boxStatus[box(i,j)][k-1] != true;
    }

    public int box(int i, int j){
        return 3*(i/3) + j/3;
    }
}