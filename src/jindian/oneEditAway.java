package jindian;

public class oneEditAway {

    public static boolean oneEditAway(String first, String second) {
        int len1 = Math.max(first.length(), second.length());
        int len2 = Math.min(first.length(), second.length());
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        // first始终指向较长的字符串
        if (len1 != first.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int cnt = 0;
        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt > 1) {
                return false;
            }
        }else {
            int i = 0;
            int j = 0;
            while (j < len2) {
                if (cnt > 1) {
                    return false;
                }
                if (first.charAt(i) != second.charAt(j)) {
                    cnt++;
                    i++;
                    continue;
                }
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (oneEditAway("park", "spake")) {
            System.out.println("...");
        }else {
            System.out.println(222);
        }
    }
}
