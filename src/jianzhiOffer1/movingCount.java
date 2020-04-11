package jianzhiOffer1;

public class movingCount {

    private static int mm;
    private static int nn;
    private static int kk;
    public static int movingCount(int m, int n, int k) {
        mm = m;
        nn = n;
        kk = k;
        int res = 0;
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, 0, vis);
    }

    private static int dfs(int i, int j, int sum, boolean[][] vis) {
        if (sum > kk || i == mm || j == nn || vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;
        return 1 + dfs(i + 1, j, sums(i + 1, j), vis) + dfs(i, j + 1, sums(i, j + 1), vis);
    }

    private static int sums(int i, int i1) {
        int temp1 = 0;
        int temp2 = 0;
        while (i != 0) {
            temp1 = temp1 + i % 10;
            i = i / 10;
        }
        while (i1 != 0) {
            temp2 = temp2 + i1 % 10;
            i1 = i1 / 10;
        }
        return temp1 + temp2;
    }

    public static void main(String[] args) {
        movingCount(16, 8, 4);
    }
}
