package jianzhiOffer6;


/**
 * 反转单词
 */
public class reverseWords {

    public static String reverseWords(String s) {
        String ts = s.trim();
        String[] strings = ts.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        reverseWords("a good   example");
    }
}
