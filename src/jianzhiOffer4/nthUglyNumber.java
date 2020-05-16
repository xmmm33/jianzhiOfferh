package jianzhiOffer4;


import java.util.ArrayList;
import java.util.List;

/**
 * 丑数
 */
public class nthUglyNumber {

    public static int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        List<Integer> temp = new ArrayList<>();
        int two = 0;
        int three = 0;
        int five = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                temp.add(1);
                continue;
            }
            int a = Math.min(temp.get(two) * 2, Math.min(temp.get(three) * 3, temp.get(five) * 5));
            if (a == temp.get(two) * 2) {
                two++;
            }
            if (a == temp.get(three) * 3) {
                three++;
            }
            if (a == temp.get(five) * 5) {
                five++;
            }
            temp.add(a);
        }
        return temp.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));;
    }
}
