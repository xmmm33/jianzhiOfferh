package jianzhiOffer6;


import java.util.ArrayList;
import java.util.List;

/**
 * 圈子里最后剩的数字
 */
public class lastRemaining {

    public int lastRemaining(int n, int m) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            temp.remove(index);
            n--;
        }
        return temp.get(0);
    }
}
