package jindian4;

public class findClosedNumbers {

    // 下一个数
    public static int[] findClosedNumbers(int num) {
        int cnt1 = Integer.bitCount(num);
        int high = num;
        int low = num;
        int[] res = new int[2];
        int k = 0;
        boolean h = false;
        boolean l = false;
        while (true) {
            high = high + 1;
            low = low - 1;
            if (low < 0) {
                res[k++] = -1;
                if (k >= 2) {
                    break;
                }
            }
            int cnth = Integer.bitCount(high);
            int cntl = Integer.bitCount(low);
            if (cnt1 == cnth && !h) {
                res[k++] = high;
                h = true;
                if (k >= 2) {
                    break;
                }
            }
            if (cnt1 == cntl && !l) {
                res[k++] = low;
                l = true;
                if (k >= 2) {
                    break;
                }
            }
        }
        if (res[0] < res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        findClosedNumbers(1837591841);
    }
}
