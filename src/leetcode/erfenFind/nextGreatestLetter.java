package leetcode.erfenFind;

/**
 * 寻找数组中大于target字符的最小字符
 *
 */
public class nextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(letters[mid] > target){
                h = mid - 1;
            }else {
                l = mid +1;
            }
        }
        // 如果l的值小于数组长度，说明数组中有比target大的字符；
        // 如果l的值大于数组长度，说明循环中一直走的是else分支，就是没有比target大的字符，里面全是比target小的字符
        return l < letters.length ? letters[l] : letters[0];
    }
}
