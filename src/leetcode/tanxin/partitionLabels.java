package leetcode.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字符数组，使得一个字符只能出现在一个分段中，而且尽可能的让分段更多
 */
public class partitionLabels {

    public List<Integer> partitionLabels(String S) {
        if (null == S || 0 == S.length()) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int len = S.length();

        // 做映射表，记录每个字母最后出现的位置
        int[] ma = new int[26];
        for (int i = 0; i < len; ++i) {
            ma[S.charAt(i) - 'a'] = i;
        }

        int left = 0;
        while(left < len){
            int cnt = 0;
            // 最小右边界
            int right = ma[S.charAt(left) - 'a'];
            for(int i = left;i<=right;i++){
                cnt++;
                // 如果中间字符最后出现的下标大于首字母出现的下标，则更新right
                if(ma[S.charAt(i)-'a'] > right){
                    right = ma[S.charAt(i)-'a'];
                }
            }
            // 下一次循环从右边界后的第一个元素开始
            left = right+1;
            res.add(cnt);
        }
        return res;
    }
}
