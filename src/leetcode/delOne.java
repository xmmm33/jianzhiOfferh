package leetcode;

public class delOne {

    public static void main(String[] args) {
        boolean res = ishuiwen("abcdd");
    }

    private static boolean ishuiwen(String abcdd) {
        int i = 0;
        int j = abcdd.length() - 1;
        while (i < j) {
            if (abcdd.charAt(i) == abcdd.charAt(j)) {
                i++;
                j--;
            }else {
                String s1 = abcdd.substring(i, j);
                String s2 = abcdd.substring(i + 1, j + 1);
                return ishui(s1) || ishui(s2);
            }
        }
        return true;
    }

    private static boolean ishui(String s2) {
        int i =0;
        int j = s2.length() - 1;
        while (i < j) {
            if (s2.charAt(i) == s2.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
