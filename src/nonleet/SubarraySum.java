package nonleet;

/**
 * Created by codefish on 1/30/15.
 */
import java.util.*;
public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        ArrayList<Integer> results = new ArrayList<Integer>();
        int sum = 0;
        sums.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sums.containsKey(sum)){
                results.add(sums.get(sum) + 1);
                results.add(i);
            }
            sums.put(sum, i);
        }
        return results;
    }
    public int[] subarraySum(int[] nums, int target){
        int i = -1, j = -1, sum = 0;
        int[] ret = new int[2];
        while(i <= j && j < nums.length - 1){
            if(sum + nums[j+1] < target){
                sum += nums[j+1];
                if(i == -1) i = j + 1;
                j++;
            } else if(sum + nums[j+1] == target){
                ret[0] = i; ret[1] = j + 1;
                System.out.println(Arrays.toString(ret));
                return ret;
            } else {
                sum -= nums[i];
                i++;
            }
        }
        return ret;
    }
}
