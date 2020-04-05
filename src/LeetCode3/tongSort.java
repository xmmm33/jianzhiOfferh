package LeetCode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tongSort {


    /**
     * 返回一个数组中出现次数前k的数字集合
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> tongSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (bucket[key] == null) {
                bucket[count] = new ArrayList<>();
            }
            // 数字出现的次数作为桶下标
            bucket[count].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i >=0 ; i--) {
            if (bucket[i] == null) {
                continue;
            }
            // 可以把桶中的所有加入到结果集中
            if (bucket[i].size() <= (k - res.size())) {
                res.addAll(bucket[i]);
            }else {
                // 只能往结果集中放入k-size个了
                res.addAll(bucket[i].subList(0, k - res.size()));
            }
        }

        return res;
    }
}
