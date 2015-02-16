package nonleet;

/**
 * Created by codefish on 1/21/15.
 */
public class WiggleSort {
    public void wiggleSort(int[] a){
        int n = a.length;
        if(n <= 1) return;
        /*
        if(a[0] > a[1]) {
            int tmp = a[1];
            a[1] = a[0];
            a[0] = tmp;
        }*/
        for(int i = 2; i < n; i++){
            if(a[i-2] < a[i-1]){
                if(a[i] > a[i-1]){
                    int tmp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = tmp;
                }
            } else {
                if(a[i] < a[i-1]){
                    int tmp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = tmp;
                }

            }
        }
    }
}
