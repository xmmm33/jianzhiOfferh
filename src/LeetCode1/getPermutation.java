package LeetCode1;


import java.util.ArrayList;
import java.util.List;

public class getPermutation {

    /**
     * 第k个排列
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        if (n < 1) {
            return "";
        }
        int[] nums = new int[n];
        List<String> res = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            nums[i] = i+1;
        }
        dfs(nums, k, "",res);
        if (!res.isEmpty()) {
            return res.get(0);
        }else {
            return "";
        }

    }

    private static void dfs(int[] nums, int k, String path,List<String> res) {
        if (path.length() == nums.length) {
            k--;
            if (k == 0) {
                res.add(path);
                return;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(String.valueOf(nums[i]))) {
                continue;
            }
            path = path + nums[i];
            dfs(nums, k, path,res);
            path = path.substring(0, path.length() - 1);
        }
    }

    public static void main(String[] args) {
        getPermutation(3, 3);
    }
}
