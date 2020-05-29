package jindian2;

import java.util.Arrays;

public class isFlipedString {

    // 字符串轮转
    public static boolean isFilpedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        char[] s11 = s1.toCharArray();
        char[] s22 = s2.toCharArray();
        Arrays.sort(s11);
        Arrays.sort(s22);
        return String.valueOf(s11).equals(String.valueOf(s22));
    }

    // 力扣解法
    public static boolean isFilpedString2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        s1 = s1 + s1;
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        isFilpedString("waterbottle", "erbottlewat");
    }
}
