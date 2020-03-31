package leetcode;

public class maximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int[] hrights = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j] == '1') {
                    hrights[j] = hrights[j] + 1;
                }else {
                    hrights[j] = 0;
                }
            }
            max = Math.max(max, countMax(hrights));
        }
        return max;
    }

    private static int countMax(int[] hrights) {
        if (hrights.length < 1) {
            return 0;
        }
        if (hrights.length == 1) {
            return hrights[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <hrights.length ; i++) {
            int high = hrights[i];
            for (int j = i; j < hrights.length; j++) {
                high = Math.min(high, hrights[j]);
                int tempres = (j - i + 1) * high;
                max = Math.max(max, tempres);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'0', '1'}, {'1', '0'}}));;
    }
}
