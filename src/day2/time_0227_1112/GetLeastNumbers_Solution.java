package day2.time_0227_1112;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers_Solution {

    /**
     * 自己的思路
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        GetLeastNumbers_SolutionTwo(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 5);
    }
    /**
     * 大根堆：任何一个父节点都比他的子节点都大 O（logn）
     * 小根堆：任何一个父节点都比他的子节点都小
     * 堆必须都是完全二叉树（叶子节点尽量靠左）
     * 为什么要使用堆呢？因为折半查找查找很快，但是如果要替换的话就很慢了
     * 如果要找最小的k个数，那么就使用最大堆，每次比较根节点，如果比他小就进行替换
     *
     * 大根堆用数组表示 （index-1 / 2）表示index节点的父节点
     *               （index * 2 + 1）表示index节点的左孩子
     *               （index * 2 + 2）表示index节点的右孩子
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_SolutionTwo(int [] input, int k) {
        if (input.length < 1 || input == null || k > input.length || k == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        // 创建大根堆
        int[] maxHeap = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            maxHeap[i] = input[i];
        }
        buildMaxHeap(maxHeap, input.length);
        // 调整堆 头结点发生改变
        for (int i = 0; i < maxHeap.length; i++) {
            System.out.println(maxHeap[i]);
            ret.add(maxHeap[i]);
        }
        heapSort(maxHeap);
        for (Integer i : maxHeap) {
            System.out.println(i);
        }
        return ret;
    }

    /**
     * @Description: 构造大根堆 第一次找到树的最后一个节点的父节点 然后开始调整
     * @Param: [arr, length]  length:数组长度 作为是否跳出循环的条件
     * @return: void
     * @Date: 2020/1/30-22:06
     */
    private static void buildMaxHeap(int[] maxHeap, int length) {
        if (maxHeap == null || maxHeap.length == 0 || maxHeap.length == 1) {
            return;
        }
        // length-1表示最后一个节点位置
        // i表示length-1节点的父节点
        for (int i = (length - 2) / 2; i >= 0; i--) {
            adjust(maxHeap, i, maxHeap.length);
        }
    }

    /**
     *
     * @param maxHeap 堆数组
     * @param parent 需要调整的元素index
     * @param length 需要调整到数组的哪个位置
     */
    private static void adjust(int[] maxHeap, int parent, int length) {
        int root = maxHeap[parent];
        // i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * parent + 1; i <= length-1; i = 2*i+1) {
            // 如果parent节点的左孩子小于右孩子,取右孩子的index，否则取i
            if (i+1 < length && maxHeap[i] < maxHeap[i + 1]) {
                i++;
            }
            // 如果根节点的值大于左右孩子中较大的那一个，调整结束
            if (root >= maxHeap[i]) {
                break;
            }else {
                // 否则将较大的值调整到parent节点的位置
                maxHeap[parent] = maxHeap[i];
                // 调整parent的值，以便继续向下调整
                parent = i;
            }
        }
        // 被调整的节点的值放入最终位置
        maxHeap[parent] = root;
    }

    /**
     * 堆排序
     * 数组[0]总是为最大的值，每次交换这个值到数组最后，然后数组前面的进行堆调整继续形成大顶堆
     */
    public static void heapSort(int[] heaps) {
        if (heaps.length == 0) {
            return;
        }
        for(int i=heaps.length-1;i>0;i--){
            //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            int temp = heaps[0];
            heaps[0] = heaps[i];
            heaps[i] = temp;
            //将剩余的元素整理成堆,需要调整的元素就是parent这个元素，主需要调整到数组倒数第二个位置即可，因为最后一个位置已经放入了最大值，不参与堆调整
            adjust(heaps, 0,i);
        }
    }
}
