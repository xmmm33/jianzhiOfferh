package LeetCode4;

public class dailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if (T.length < 1) {
            return res;
        }
        for (int i = 0; i < T.length; i++) {
            res[i] = 0;
            int cnt = 0;
            for (int j = i + 1; j < T.length; j++) {
                cnt++;
                if (T[j] > T[i]) {
                    res[i] = cnt;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
