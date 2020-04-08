package LeetCode4;

public class hammingDistance {

    /**
     * 汉明距离就是两个整数的二进制位中不同的个数
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int cnt = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                cnt++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        hammingDistance(1, 4);
    }

    public static int totalHammingDistance(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                cnt = cnt + hammingDistance(nums[i], nums[j]);
            }
        }
        return cnt;
    }
}
