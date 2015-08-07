package lin.E5_20150807;

/**
 * Created by Paul on 8/6/15.
 * http://www.lintcode.com/en/problem/trailing-zeros/
 */
//Trailing Zeros
//
//        29% Accepted
//        Write an algorithm which computes the number of trailing zeros in n factorial.
//
//        Have you met this question in a real interview? Yes
//        Example
//        11! = 39916800, so the out should be 2
//
//        Challenge
//        O(log N) time
//首先别忘了什么是factorial，就是阶乘。那么很容易想到需要统计(2,5)对的个数，因为2×5=10。
// 但是这个条件放松一下就会发现其实只要数5的个数就好了，因为2实在是比5要多的多。
//        那么这道题目就转化成为计算从1到n之间所有数的5的约数个数总和。很简单的想到能不能用n/5得到。
// 比如当n为19的时候，19/5 = 3.8，那么就是有3个约数包含5的数，分别是5, 10, 15。
// 但是有的数可能被5整除多次，比如说25。这样的数一个就能给最后的factorial贡献好几个5。
//        最后的解法就是对n/5+n/25+n/125+…+进行求和，当n小于分母的时候，停止。
// 分母依次为5^1, 5^2, 5^2… 这样的话在计算5^2的时候，能被25整除的数里面的两个5，其中一个已经在5^1中计算过了。
// 所以5^2直接加到count上。
//
//        [注意事项]
//        1）注意题目的要求是logarithmic time complexity，所以对于for循环，i的变化肯定不能是线性的，
// 需要是乘法（递增）或者除法（递减）。
//        2）如果面试被考到，先跟面试官扯扯最笨的方法。然后举几个例子。
//        3）注意对n<0的处理 [Code]
public class E2TrailingZeros {
    /*
 * param n: As desciption
 * return: An integer, denote the number of trailing zeros in n!
 */
    public static  long trailingZeros(long n) {
        // write your code here
        if ( n<0 ) return -1;
        int count = 0;
        for (long i=5; n/i>=1; i*=5) {
            count += n / i;
        }
        return count;
    }

    public static void main(String [] args) {
        long a = 26;
        long b = trailingZeros(a);
    }
}
