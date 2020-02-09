/**
 * 在二维数组中查找
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 1 2 3 4
 * 3 4 5 6
 * 4 6 8 10
 * 9 11 13 15
 * 给定一个数，判断二维数组中是否包含该数
 */
public class Find {

    /**
     * 时间复杂度是O(mn)
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean FindTwo(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (target > array[i][j]) {
                    break;
                } else if (target < array[i][j]) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (FindTwo(14, new int[][]{{1, 2, 3}, {2, 3, 5}, {5, 12, 13}})) {
            System.out.println("找到了");
        } else {
            System.out.println("....");
        }
    }
}
