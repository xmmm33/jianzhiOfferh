package LeetCode3;

public class searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
                continue;
            }
            if (target < matrix[row][col]) {
                col--;
                continue;
            }
            if (target == matrix[row][col]) {
                return true;
            }
        }
        return false;
    }
}
