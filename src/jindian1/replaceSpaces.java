package jindian1;

public class replaceSpaces {

    // 把空格替换成%20 要求只能用数组
    public String replaceSpaces(String S, int length) {
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                cnt++;
            }
        }
        int size = length + 2 * cnt;
        char[] res = new char[size];
        int k = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                res[k++] = '%';
                res[k++] = '2';
                res[k++] = '0';
            }else {
                res[k++] = S.charAt(i);
            }
        }
        return String.valueOf(res);
    }
}
