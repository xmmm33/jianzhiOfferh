package jianzhiOffer2;

public class printNumbers {

    public static int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        for (int i = 0; i <max ; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        printNumbers(3);
    }
}
