package lin.E2_20150804;

/**
 * Created by Paul on 8/3/15.
 * http://www.lintcode.com/en/problem/merge-sorted-array/
 */
//Merge Sorted Array
//
//        35% Accepted
//        Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//        Have you met this question in a real interview? Yes
//        Example
//        A = [1, 2, 3, empty, empty], B = [4, 5]
//
//        After merge, A will be filled as [1, 2, 3, 4, 5]
//
//        Note
//        You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
public class E64MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if(A == null && B == null) {
            return;
        }

        for(int i = A.length - 1; i >= 0; i--) {
            if(m > 0 && n > 0) {
                if(A[m-1] < B[n-1]) {
                    A[i] = B[n-1];
                    n--;
                } else {
                    A[i] = A[m-1];
                    m--;
                }
            } else if( n > 0) {
                A[n-1] = B[n-1];
                n--;
            } else if(m > 0) {
                A[m-1] = A[m-1];
                m--;
            }
        }


    }
}
