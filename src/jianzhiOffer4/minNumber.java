package jianzhiOffer4;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数组排成最小的数
 */
public class minNumber {

    /**
     * 思路：
     * 对数组进行排序；
     * 排序的规则是，比较当前元素a，加上前一个元素b，和b+a的大小，
     * 例如，10,2；排序就是102 < 210,所以10 < 2
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(String.valueOf(nums[i]));
        }
        temp.sort((a, b) -> (a + b).compareTo(b + a));
        System.out.println(String.join("", temp));
        return String.join("", temp);
    }

    public static void main(String[] args) {
        minNumber(new int[]{10, 2});
    }
}
