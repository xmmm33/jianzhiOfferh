package jianzhiOffer1;

public class minArray {

    public int minArray(int[] numbers) {
        if (numbers.length < 1) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] <= numbers[i + 1]) {
                continue;
            }else {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
