package round1;
public class LongestParenteses {

    public int longestValidParentheses(String s) {

        if(s == null) return 0;
        int n = s.length();
        char[] a = s.toCharArray();
        if(n <= 1) return 0;
        int[] f = new int[n];
        f[0] = 0;
        int max = 0;
        for(int i = 1; i < n; i++){
            if(a[i] == '(') {
                f[i] = 0;
            } else {
                if(a[i-1] == '(') {
                    f[i] = 2;
                    if(i-2>=0){
                        f[i] += f[i-2];
                    }
                } else {
                    if(i-f[i-1]-1 >=0){
                        if(f[i-f[i-1]-1] == '('){
                            f[i] = f[i-1]+2;
                            if(i-f[i-1]-2 >= 0)
                                f[i] += f[i-f[i-1]-2];
                        } else {
                            f[i] = 0;
                        }
                    }
                }
                max = Math.max(f[i], max);
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(" " + f[i]);
        }
        System.out.println();
        return max;
    }
}
