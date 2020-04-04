package LeetCode3;

public class countPrimes {

    public int countPrimes(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        for (int i = 2; i < n; i++) {
            if (res[i] == 0) {
                continue;
            }
            for (int j = 2; i * j < n; j++) {
                res[i * j] = 0;
            }
        }
        int ret = 0;
        for (int i = 2; i < n; i++) {
            if (res[i] == 1) {
                ret++;
            }
        }
        return ret;
    }
}
