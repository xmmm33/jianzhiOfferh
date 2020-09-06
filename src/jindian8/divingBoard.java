package jindian8;

public class divingBoard {

    // 跳水板
    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     *
     * 示例：
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        // 木板数量小于1，无解
        if (k < 1) {
            return new int[]{};
        }
        // 两块板子长度一样只有一种解
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        // 枚举较长木板的数量，那么（k-m）即是短板的数量
        for (int i = 0; i <= k; i++) {
            res[i] = longer * i + shorter * (k - i);
        }
        return res;
    }
}
