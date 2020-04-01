package LeetCode1;

public class sortColors {


    public static void sortColors(int[] nums) {
        if (nums.length < 1) {
            return;
        }
        int first = 0;
        int second = 0;
        int last = nums.length - 1;
        while (second <= last) {
            if (nums[second] == 1) {
                second++;
            } else if (nums[second] == 0) {
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second] = temp;
                second++;
                first++;
            } else if (nums[second] == 2) {
                int temp = nums[last];
                nums[last] = nums[second];
                nums[second] = temp;
                last--;
            }
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
