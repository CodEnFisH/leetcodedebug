package round3;

/**
 * Created by codefish on 1/29/15.
 */
public class Median {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if((m + n) % 2 == 0) return (findK(A, 0, m - 1, B, 0, n - 1, (m + n)/2) +
                findK(A, 0, m - 1, B, 0, n - 1, (m + n )/2 + 1 )) / 2;
        return findK(A, 0, m - 1, B, 0, n - 1, (m + n) / 2 + 1);
    }
    public double findK(int[] a, int la, int ra, int[] b, int lb, int rb, int k){
        if(la > ra) return b[lb+k-1];
        if(lb > rb) return a[la+k-1];
        if(k == 1) return Math.min(a[la], b[lb]);
        int m = ra - la + 1, n = rb - lb + 1;
        if(m + n == k) return Math.max(a[ra], b[rb]);
        if(m > n) return findK(b, lb, rb, a, la, ra, k);
        int pa = Math.min(k/2, m), pb = k - pa;
        if(a[la + pa - 1] > b[lb + pb - 1])
            return findK(a, la, la + pa - 1, b, lb + pb, rb, k - pb);
        else if(a[la + pa - 1] < b [lb + pb - 1])
            return findK(a, la + pa, ra, b, lb, lb +pb - 1, k - pa);
        else return a[la + pa - 1];
    }
}
