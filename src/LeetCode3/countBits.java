package LeetCode3;

public class countBits {

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <=num ; i++) {
            int cnt = 0;
            int temp = i;
            while (temp > 0) {
                cnt++;
                temp = temp & (temp - 1);
            }
            res[i] = cnt;
        }
        return res;
    }

    public static int count1bit(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
