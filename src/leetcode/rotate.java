package leetcode;

public class rotate {

    public int findSpecialInteger(int[] arr) {
        int cnt = 0;
        int pre = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (pre == arr[i]) {
                cnt++;
                if (cnt > arr.length / 4) {
                    return arr[i];
                }
            }else {
                pre = arr[i];
                cnt= 1;
            }
        }
        return -1;
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
