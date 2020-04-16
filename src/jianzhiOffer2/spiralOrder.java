package jianzhiOffer2;

public class spiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int k = 0;
        while (k < matrix.length * matrix[0].length) {
            for (int i = left; i <= right; i++) {
                res[k] = matrix[top][i];
                if (k == matrix.length * matrix[0].length - 1) {
                    return res;
                }
                k++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[k] = matrix[i][right];
                if (k == matrix.length * matrix[0].length - 1) {
                    return res;
                }
                k++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[k] = matrix[bottom][i];
                if (k == matrix.length * matrix[0].length - 1) {
                    return res;
                }
                k++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[k] = matrix[i][left];
                if (k == matrix.length * matrix[0].length - 1) {
                    return res;
                }
                k++;
            }
            left++;
        }
        return res;
    }
}
