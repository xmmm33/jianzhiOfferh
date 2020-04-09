package LeetCode4;

public class findUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int l = 0;
        int r = -1;
        // 寻找右边界：
        //从前往后遍历的过程中，用max记录遍历过的最大值，如果max大于当前的nums[i]，说明nums[i]的位置不正确，属于需要排序的数组，因此将右边界更新为i，然后更新max；
        // 这样最终可以找到需要排序的数组的右边界，右边界之后的元素都大于max；
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                r = i;
            }else {
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}
