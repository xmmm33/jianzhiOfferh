package jindian4;

public class exchangeBits {

    public static int exchangeBits(int num) {
        //获取偶数位 0xaaaaaaaa=1010...1010(二进制1010 x8)
        int even = num & 0xaaaaaaaa;
        //获取奇数位 0x55555555=0101...0101(二进制0101 x8)
        int odd = num & 0x55555555;
        return (even >> 1) | (odd << 1);
    }


    public static void main(String[] args) {
        exchangeBits(3);
    }
}
