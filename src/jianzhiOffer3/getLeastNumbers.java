package jianzhiOffer3;


import java.util.Arrays;

/**
 * 最小的K个数
 */
public class getLeastNumbers {


    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k < 1) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k < 1) {
            return new int[0];
        }
        int[] heap = new int[k];
        for (int i = 0; i <k ; i++) {
            heap[i] = arr[i];
        }
        buildheap(heap);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                buildheap(heap);
            }
        }
        return heap;
    }

    private static void buildheap(int[] heap) {
        if (heap.length < 1) {
            return;
        }
        for (int i = (heap.length-2) / 2; i >= 0; i--) {
            adjust(heap, i, heap.length);
        }
    }

    private static void adjust(int[] heap, int parent, int length) {
        int root = heap[parent];
        for (int i = 2 * parent + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && heap[i] < heap[i+1]) {
                i = i+1;
            }
            if (root > heap[i]) {
                break;
            } else {
                int temp = heap[i];
                heap[i] = heap[parent];
                heap[parent] = temp;
                parent = i;
            }
        }
    }

    public static void main(String[] args) {
        getLeastNumbers2(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
    }
}
