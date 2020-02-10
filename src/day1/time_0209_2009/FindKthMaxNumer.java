package day1.time_0209_2009;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给一个无序数组，找到第K大的元素值
 */
public class FindKthMaxNumer {

    public int find(Integer[] arr) {
        // 先进行数组的排序 升序
        Arrays.sort(arr);
        // 降序方式
        // 1. Arrays.sort(arr, Collections.reverseOrder());
        /* 2. MyCom myCom = new MyCom();
              Arrays.sort(arr,myCom);*/
        // 然后是取length-3的数据
        return arr[arr.length - 3];
    }

    class MyCom implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
