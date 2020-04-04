package LeetCode3;

public class isUgly {

    public static boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }
            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }
            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if (isUgly(6)) {
            System.out.println("222");
        }
    }
}
