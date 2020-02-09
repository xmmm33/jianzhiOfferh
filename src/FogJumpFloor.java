/**
 * 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 比如台阶有3节 跳法：111,12,21
 */
public class FogJumpFloor {

    /**
     * 通过找规律发现
     * target=0，输出0
     * target=1，输出1
     * target=2，输出2
     * target=3，输出3
     * target=4，输出5
     * target=5，输出8
     * 类似斐波拉切数列
     * 递归实现
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    /**
     * 循环实现
     * @param target
     * @return
     */
    public static int JumpFloorTwo(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int ret = 0;
            int a = 1;
            int b = 2;
            for (int i = 3; i < target + 1; i++) {
                ret = a + b;
                a = b;
                b = ret;
            }
            return ret;
        }
    }
    public static void main(String[] args) {
        System.out.println(JumpFloorTwo(6));
    }
}
