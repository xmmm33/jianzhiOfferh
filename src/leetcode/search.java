package leetcode;

public class search {

    public static int search(int[] nums, int target) {
        int left = 0;
        int ri = nums.length - 1;
        while (left <= ri) {
            if (target < nums[left] && target > nums[ri]) {
                return -1;
            }
            if (target > nums[left]) {
                left++;
            }else if (target == nums[left]){
                return left;
            }
            if (target < nums[ri]) {
                ri--;
            }else if (target == nums[ri]){
                return ri;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
