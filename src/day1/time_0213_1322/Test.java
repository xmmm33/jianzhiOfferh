package day1.time_0213_1322;

import java.util.Scanner;

/**
 * 序列最小化
 * 有一个长度为N的序列。一开始，这个序列是1, 2, 3,... n - 1, n的一个排列。
 *
 * 对这个序列，可以进行如下的操作：
 *
 * 每次选择序列中k个连续的数字，然后用这k个数字中最小的数字替换这k个数字中的每个数字。
 *
 * 我们希望进行了若干次操作后，序列中的每个数字都相等。请你找出需要操作的最少次数。
 *
 * 思路：一共n个数，最多需要把n-1个数字变为一样的，每次取k个数，最多能把k-1个数变为一样。
 *     所以，把n个数全部变为一样的，至少需要n-1/k-1向上取整
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int k = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] ser = new int[n];
        if( n == 0){
            System.out.println(0);
            return;
        }
        if (k >= n) {
            System.out.println(1);
            return;
        }
        for(int i =0;i<n;i++){
            ser[i] = sc.nextInt();
        }
        int ret = (int) (Math.ceil((double) (ser.length-1)  / (k-1)));
        System.out.println(ret);
    }
}
