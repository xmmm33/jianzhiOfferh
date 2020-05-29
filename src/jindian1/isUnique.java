package jindian1;

public class isUnique {

    // 判断一个字符串是否有重复的字符；
    // 只需要判断当前字符的下表，和这个字符在字符串中最后一次出现的下表是否相等，如果不等就表示有重复的字符
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (astr.lastIndexOf(c) != i) {
                return false;
            }
        }
        return true;
    }
}
