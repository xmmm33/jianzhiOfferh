package jianzhiOffer1;

public class findNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] > target) {
                    continue;
                }
                if (matrix[i][j] < target) {
                    break;
                }
                return true;
            }
        }
        return false;
    }
}
