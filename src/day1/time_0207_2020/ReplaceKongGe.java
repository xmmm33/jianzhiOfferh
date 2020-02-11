package day1.time_0207_2020;

/**
 * 替换空格
 *
 * @author MSI
 */
public class ReplaceKongGe {

    private static String replaceSpace(String str) {
        char[] strings = str.toCharArray();
        StringBuffer p = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != ' ') {
                p.append(strings[i]);
            } else {
                p.append("%20");
            }
        }
        return p.toString();
    }

    private static String re(String str) {
        char[] r = str.toCharArray();
        char[] p = new char[100];
        int j = 0;
        for (int i = r.length - 1; i >= 0; i--) {
            if (r[i] != ' ') {
                p[j++] = r[i];
            } else {
                p[j++] = '0';
                p[j++] = '2';
                p[j++] = '%';
            }
        }
        return new StringBuilder(new String(p).trim()).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(re("aaaa bbbb cccc dddd fff ggg hhh hh"));
    }
}
