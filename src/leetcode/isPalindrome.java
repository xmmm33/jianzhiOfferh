package leetcode;

public class isPalindrome {

    public boolean isPalindrome(int x) {
        String xs = String.valueOf(x);
        if (xs.length() == 1) {
            return true;
        }
        int left = 0;
        int right = xs.length() - 1;
        while (left < right) {
            if (xs.charAt(left) != xs.charAt(right)) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }
}
