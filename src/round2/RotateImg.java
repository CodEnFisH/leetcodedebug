package round2;

/**
 * Created by codefish on 1/14/15.
 */
public class RotateImg {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int frame = 0; frame < n/2; frame++){
            for(int j = frame; j < n - 1 - frame; j++){
                int i = frame, tmp = matrix[i][j];
                for(int k = 0; k < 3; k++){
                    matrix[i][j] = k == 2 ? tmp: matrix[n-1-j][i];
                    i = n-1-j;
                    j = i;
                }
            }
        }
    }
}
