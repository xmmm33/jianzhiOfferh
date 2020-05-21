package jianzhiOffer6;

/**
 * 左旋转字符串
 */
public class reverseLeftWords {

    public static String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String s1 = s.substring(0,n);
        String s2 = s.substring(n);
        return stringBuilder.append(s2).append(s1).toString();
    }

    public static void main(String[] args) {
        reverseLeftWords("abcdefg", 2);
    }
}
