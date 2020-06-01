package jindian4;

public class printBin {

    // 十进制小数转换为二进制表示
    // 十进制整数转换为二进制和十进制小数转换为二进制的规则：https://www.runoob.com/w3cnote/decimal-decimals-are-converted-to-binary-fractions.html
    public String printBin(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        StringBuilder res = new StringBuilder("0.");
        String afterpoint = String.valueOf(num).split("\\.")[1];
        while (!afterpoint.equals("0")) {
            num = num * 2;
            res.append(num >= 1 ? 1 : 0);
            num = num >= 1 ? num - 1 : num;
            afterpoint = String.valueOf(num).split("\\.")[1];
        }
        if (res.length() > 34) {
            return "ERROR";
        }else {
            return res.toString();
        }
    }
}
