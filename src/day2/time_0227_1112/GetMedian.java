package day2.time_0227_1112;

import java.util.*;

/**
 * 数据流中的中位数
 * 奇数个的数据流采用
 * 这个数据流是要排序的
 * 把数据流分成两半，前半小的用大顶堆存放，后半大的用小顶堆存放
 */
public class GetMedian {

    private static int cnt = 0;
    // 默认的是小顶堆
    private static PriorityQueue<Integer> low = new PriorityQueue<>();
    // 大顶堆
    private static PriorityQueue<Integer> high = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public static void Insert(Integer num) {
        // 数量++
        cnt++;
        if (cnt % 2 == 1) {
            // 如果是奇数个的话
            if (!low.isEmpty() && num > low.peek()) {
                // 存进去
                low.offer(num);
                // 然后把堆中最小的弹出来
                num = low.poll();
            }
            high.offer(num);
        } else {
            // 偶数的话，此时需要存放的是最小的数
            // 注意无论是大顶堆还是小顶堆，吐出来的前提是有数
            if (!high.isEmpty() && num < high.peek()) {
                high.offer(num);
                // 把大顶堆中最大的吐出来
                num = high.poll();
            }
            // 最大的加入到小顶堆中
            low.offer(num);
        }
    }

    public static Double GetMedian() {
        String s = "10#15";
        Integer i = Integer.parseInt(s.split("#")[1],
                Integer.parseInt(s.split("#")[0]));
        double res = 0;
        if (cnt % 2 == 1) {
            res = high.peek();
        }else {
            res = (high.peek() + low.peek()) / 2.0;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> res = new HashMap<>();
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("END")) {
                break;
            }
            Integer v = Integer.parseInt(s.split("#")[1],
                    Integer.parseInt(s.split("#")[0]));
            res.put(v, res.getOrDefault(v, 0) + 1);
            s = s + "-" + v;
            list.add(s);
        }
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (res.get(Integer.parseInt(list.get(i).split("-")[1])) == 1) {
                flag = true;
                System.out.println(list.get(i).split("-")[0]);
            }
        }
        if (!flag) {
            System.out.println("None");
        }
    }
}
