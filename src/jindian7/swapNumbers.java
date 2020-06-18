package jindian7;

import java.util.Arrays;

public class swapNumbers {

    // 交换两个整数，不用中间变量
    public static int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[1] - numbers[0];
        numbers[1] = numbers[1] - numbers[0];
        numbers[0] = numbers[1] + numbers[0];
        return numbers;
    }

    public static void main(String[] args) {
        swapNumbers(new int[]{682, 42});
    }
}
