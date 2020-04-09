package LeetCode4;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return res;
        }
        int cnt = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (cnt < matrix.length * matrix[0].length) {
            for (int i = left; i <=right ; i++) {
                res.add(matrix[top][i]);
                cnt++;
                if (cnt >= matrix.length * matrix[0].length) {
                    return res;
                }
            }
            top++;
            for (int i = top; i <=bottom ; i++) {
                res.add(matrix[i][right]);
                cnt++;
                if (cnt >= matrix.length * matrix[0].length) {
                    return res;
                }
            }
            right--;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
                cnt++;
                if (cnt >= matrix.length * matrix[0].length) {
                    return res;
                }
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                cnt++;
                if (cnt >= matrix.length * matrix[0].length) {
                    return res;
                }
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
