package jindian1;

public class compressString {

    /**
     * 压缩字符串
     * @param S
     * @return
     */
    public static String compressString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int cnt = 1;
            stringBuilder.append(S.charAt(i));
            while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                i++;
                cnt++;
            }
            stringBuilder.append(cnt);
        }
        if (stringBuilder.toString().isEmpty()) {
            return S;
        }
        return stringBuilder.toString().length() >= S.length() ? S : stringBuilder.toString();
    }

    public static void main(String[] args) {
        compressString("bbbac");
    }
}
