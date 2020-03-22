package practice.sort;

public class topK {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 45, 6, 412, 1, 5, 48, 5, 12, 31, 2, 12, 5, 43, 123, 54, 6, 3};
        int k = 4;
        int[] heap = new int[k];
        for (int i = 0; i <k ; i++) {
            heap[i] = a[i];
        }
        buildheap(heap);
        for (int i = k; i < a.length; i++) {
            if (a[i] > heap[0]) {
                heap[0] = a[i];
                adjustheap(heap,0,heap.length);
            }
        }
        for (int i : heap) {
            System.out.println(i);
        }
    }

    private static void buildheap(int[] heap) {
        if (heap.length < 1) {
            return;
        }
        for (int i = (heap.length - 2) / 2; i >= 0; i--) {
            adjustheap(heap, i, heap.length);
        }
    }

    private static void adjustheap(int[] heap, int parent, int length) {
        int temp = heap[parent];
        for (int i = 2*parent+1; i <length ; i++) {
            if (i + 1 < length && heap[i] > heap[i+1]) {
                i++;
            }
            if (temp < heap[i]) {
                break;
            }else {
                int s = heap[i];
                heap[i] = heap[parent];
                heap[parent] = s;
                parent = i;
            }
        }
    }
}
