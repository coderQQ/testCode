package lin.E5_20150807;

/**
 * Created by Paul on 8/6/15.
 * //http://www.lintcode.com/en/problem/unique-paths/
 //http://www.cnblogs.com/springfor/p/3886603.html
 */
//http://www.lintcode.com/en/problem/unique-paths/
//http://www.cnblogs.com/springfor/p/3886603.html
//Unique Paths
//
//        38% Accepted
//        A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        How many possible unique paths are there?
//
//        Have you met this question in a real interview? Yes
//        Example
//        1,1
//        1,2
//        1,3
//        1,4
//        1,5
//        1,6
//        1,7
//        2,1
//
//
//
//
//
//
//        3,1
//
//
//
//
//
//        3,7
//
//        Above is a 3 x 7 grid. How many possible unique paths are there?
//
//        Note
//        m and n will be at most 100.
public class E114UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] anArray = new int[m][n];
        for(int i = 0; i < m; i++) {
            anArray[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            anArray[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                anArray[i][j] = anArray[i-1][j] + anArray[i][j-1];
            }
        }

        return anArray[m-1][n-1];

    }
}
