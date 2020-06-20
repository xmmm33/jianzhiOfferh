package jindian8;

public class maximum {

    // 不用运算符和if-else比较两个数的大小
    public static int maximum(int a, int b) {
        // 先考虑没有溢出时的情况，计算 b - a 的最高位，
        int k = b - a >>> 31;
        // 再考虑 a b 异号的情况，此时无脑选是正号的数字
        int aSign = a >>> 31, bSign = b >>> 31;
        // diff = 0 时同号，diff = 1 时异号
        int diff = aSign ^ bSign;
        // 在异号，即 diff = 1 时，使之前算出的 k 无效，只考虑两个数字的正负关系
        if (diff == 1) {
            k = bSign & diff;
        }else {
            k = k;
        }
        return a * k + b * (k ^ 1);
    }

    public static void main(String[] args) {
        maximum(-16, 50);
    }
}
