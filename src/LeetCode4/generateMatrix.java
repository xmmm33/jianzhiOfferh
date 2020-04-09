package LeetCode4;

public class generateMatrix {

    public static int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[n][];
        }
        int[][] res = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            for (int i = top; i <=bottom ; i++) {
                res[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left ; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top ; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        generateMatrix(9);
    }
}
