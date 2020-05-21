package jianzhiOffer6;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 */
public class MaxQueue {

    // 队列
    private Queue<Integer> queue;

    // 双端队列，队头始终保存当前队列中的最大元素
    private Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (!maxQueue.isEmpty()) {
            return maxQueue.peek();
        }else {
            return -1;
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        // 当插入的元素大于双端队列的队尾的元素的时候，把队尾的元素以此删除，直到双端队列队尾的元素大于插入的value元素的时候，才把value元素插入到双端队列中的队尾位置
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        int out = !queue.isEmpty() ? queue.poll() : -1;
        if (!maxQueue.isEmpty() && out == maxQueue.peek()) {
            maxQueue.poll();
        }
        return out;
    }
}
