package jianzhiOffer5;

/**
 * 找出数组中数字出现的次数
 */
public class singleNumbers {

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[2];
        }
        int[] res = new int[2];
        int k = 0;
        // 相同的元素异或肯定为0，那么k的值肯定就是那两个出现一次的元素的异或结果
        // 假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的
        // 那么可以根据数组里面所有数的第二位为0或者1将数组划分为2个。
        // 示例数组可以分为 低位第一位为0：[4,4,6]     低位第一位为1：[1]
        for (int i = 0; i < nums.length; i++) {
            k = k ^ nums[i];
        }
        // 分组 此时再将两个数组两两异或就可以得到最终结果
        int mask = k & (-k);
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] = res[0] ^ num;
            }else {
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }
}
