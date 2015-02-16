package round1;

/**
 * Created by codefish on 1/4/15.
 */
public class FindMissingInt {
    public int firstMissingPositive(int[] A) {
        int[] a = A;
        int n = a.length;
        for(int i = 0; i < n; i++){
            int target = a[i];
            while(target > 0 && target <= n && target != a[target-1]){
                int tmp = a[target-1];
                a[target-1] = target;
                target = tmp;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(" " + a[i]);
        }
        System.out.println();

        for(int i = 0; i < n; i++){
            if(a[i] != i+1) return i+1;
        }
        return n+1;
    }
}
