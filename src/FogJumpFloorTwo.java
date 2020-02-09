/**
 * 青蛙跳变态版
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FogJumpFloorTwo {

    /**
     * 通过找规律发现
     * 当 target=0；ret=0
     * 当 target=1；ret=1
     * 当 target=2；ret=2
     * 当 target=3；ret=4
     * 当 target=4；ret=8
     * 通项 ret = 2^（target-1）
     * @param target
     * @return
     */
    private static int jump(int target) {
        if (target == 0) {
            return 0;
        } else {
            return (int) Math.pow(2, target - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(jump(2));
    }
}
