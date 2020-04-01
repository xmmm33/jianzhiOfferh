package LeetCode1;

public class numTrees {

    /**
     * 从1到n的整数能构成多少不同的二叉搜索树
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
     * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则 f(i)=G(i−1)∗G(n−i)
     * 综上:G(n)=G(0)∗G(n−1)+G(1)∗G(n−2)+...+G(n−1)∗G(0)
     * 这就是卡特兰数的递推公式
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 例如  G(2) = G(0)*G(1) + G(1)*G(0)
        //      G3   = G0*G2 + G1*G1 + G2*G0
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
