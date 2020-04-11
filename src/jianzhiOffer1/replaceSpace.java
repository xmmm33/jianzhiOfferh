package jianzhiOffer1;

public class replaceSpace {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            }else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpace2(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cnt++;
            }
        }
        char[] res = new char[s.length() + cnt * 2];
        int k = res.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                res[k--] = '0';
                res[k--] = '2';
                res[k--] = '%';
            }else {
                res[k--] = s.charAt(i);
            }
        }
        return new String(res);
    }
}
