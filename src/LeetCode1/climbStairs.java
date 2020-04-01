package LeetCode1;

public class climbStairs {


    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int low = 2;
        int high = 3;
        int res = 0;
        for (int i = 0; i < n-3; i++) {
            res = low + high;
            low = high;
            high = res;
        }
        return res;
    }
}
