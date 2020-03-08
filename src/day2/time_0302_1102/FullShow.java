package day2.time_0302_1102;

import java.util.ArrayList;
import java.util.List;

public class FullShow {

    private static List<String> ret = new ArrayList();
    public static void main(String[] args) {
        char[] array = {'a','b','c'};
        finishFullPermutation(array);
    }

    private static void finishFullPermutation(char[] array) {
        fullshow(array, 0, array.length);
    }

    private static void fullshow(char[] array, int i, int length) {
        if (length < 0) {
            return;
        }
        if (i == length-1) {
            ret.add(String.valueOf(array));
        }else {
            for (int j = i; j <length ; j++) {
                // 交换首字符
                swap(array, j, i);
                // 对剩余元素进行全排列
                fullshow(array, i + 1, length);
                // 将首字符换回，以便下一次进行另外的交换
                swap(array,i,j);
            }
        }

    }

    private static void swap(char[] array, int j, int i) {
        char temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private static void full(char[] chars, int i) {
        if (i == chars.length - 1) {
            ret.add(String.valueOf(chars));
        }else {

        }
    }
}
