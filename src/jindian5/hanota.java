package jindian5;

import java.util.List;

public class hanota {

    // 汉诺塔
    public  void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hannota(A.size(), A, B, C);
    }

    private  void hannota(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 如果A柱子上只有一个盘子了，那么一定是最大的那个盘子，所以直接移动到C柱子上面
        if (size == 1) {
            removeTo(A, C);
            return;
        }
        // 把A柱子上面的n-1个盘子，借助辅助柱子C，放到柱子B上
        hannota(size - 1, A, C, B);
        // 此时A柱子剩下那个盘子是n个盘子中最大的那个盘子，把它移动到C柱子上
        removeTo(A, C);
        // 最后把刚才放到B柱子上的n-1盘子，借助辅助柱子A，放到柱子C上
        hannota(size - 1, B, A, C);
    }

    private  void removeTo(List<Integer> from, List<Integer> to) {
        to.add(from.remove(from.size() - 1));
    }

}
