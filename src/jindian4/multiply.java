package jindian4;

public class multiply {

    // 递归乘法 不能使用*号
    public static int multiply(int A, int B) {
        return calculate(Math.max(A, B), Math.min(A, B));
    }

    private static int calculate(int large, int small) {
        if (small == 1) {
            return large;
        }
        if (small == 2) {
            return large + large;
        }
        if (small % 2 == 0) {
            return calculate(large, small / 2) << 1;
        }else {
            return large + (calculate(large, small / 2) << 1);
        }
    }

    public static void main(String[] args) {
        multiply(5, 10);
    }
}
