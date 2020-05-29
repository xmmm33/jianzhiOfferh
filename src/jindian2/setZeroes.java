package jindian2;

public class setZeroes {

    // 零矩阵
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int l = 0;
                    int k = 0;
                    while (l < n) {
                        if (matrix[i][l] == 0) {
                            l++;
                            continue;
                        }
                        temp[i][l++] = 1;
                    }
                    while (k < m) {
                        if (matrix[k][j] == 0) {
                            k++;
                            continue;
                        }
                        temp[k++][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
    }
}
