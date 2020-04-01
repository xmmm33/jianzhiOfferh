package LeetCode1;

import java.util.Arrays;

public class nextPermutation {

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i == 0) {
                Arrays.sort(nums);
            }else {
                if (nums[i] > nums[i - 1]) {
                    int tempindex = i-1;
                    for (int j = nums.length-1; j >=0 ; j--) {
                        if (nums[j] > nums[tempindex]) {
                            int temp = nums[j];
                            nums[j] = nums[tempindex];
                            nums[tempindex] = temp;
                            Arrays.sort(nums,tempindex+1,len);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
    }
}
