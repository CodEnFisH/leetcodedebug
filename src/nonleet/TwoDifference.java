package nonleet;

/**
 * Created by codefish on 2/15/15.
 */
public class TwoDifference {
    public int[] twoDifference(int[] num, int target){
        int i = 0, j = 1, ret[] = {-1, -1}, t = target > 0 ? -target : target;
        while(j < num.length){
            if(num[i] - num[j] < t) i++;
            else if(num[i] - num[j] == t) {
                if(t == target) {
                    ret[0] = num[i];
                    ret[1] = num[j];
                } else {
                    ret[1] = num[i];
                    ret[0] = num[j];
                }
                return ret;
            } else j++;
            if(i == j) j++;
        }
        return ret;
    }
}
