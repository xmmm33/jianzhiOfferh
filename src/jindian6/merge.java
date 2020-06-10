package jindian6;

public class merge {

    // 合并排序的数组
    public static void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        int k = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[k--] = A[a--];
            }else {
                A[k--] = B[b--];
            }
        }
        while (b >= 0) {
            A[k--] = B[b--];
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
