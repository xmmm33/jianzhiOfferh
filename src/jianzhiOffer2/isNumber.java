package jianzhiOffer2;

public class isNumber {


    public boolean isNumber(String s) {
        if (s.length() < 1) {
            return false;
        }
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] temp = s.trim().toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= '0' && temp[i] <= '9') {
                numSeen = true;
            } else if (temp[i] == '.') {
                // 小数点之前不能出现小数点或者e
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (temp[i] == 'e' || temp[i] == 'E') {
                // e之前不能出现e，必须出现数字
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                // 重置numSeen，为了排除123e这种情况
                numSeen = false;
            } else if (temp[i] == '-' || temp[i] == '+') {
                // +-出现在0位置或者e后面的第一个位置才是合法的
                if (i != 0 && temp[i - 1] != 'e' && temp[i - 1] != 'E') {
                    return false;
                }
            }else {
                return false;
            }
        }
        return numSeen;
    }
}
