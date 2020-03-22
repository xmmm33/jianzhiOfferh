package practice.sort;

/**
 * 建堆 On
 * 调整堆 nlogn
 */
public class heaptest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 6, 1, 32, 5, 4, 5, 1, 2, 54, 3, 131};
        buildheap(a);
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort(int[] a) {
        for (int i = a.length-1; i >0 ; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjus(a,0,i);
        }
    }

    private static void buildheap(int[] a) {
        if (a.length < 1) {
            return;
        }
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjus(a, i, a.length);
        }
    }

    private static void adjus(int[] a, int parent, int length) {
        int temp = a[parent];
        for (int i = 2*parent+1; i <length ; i = 2*i+1) {
            if (i + 1 < length && a[i] > a[i + 1]) {
                i++;
            }
            if (temp < a[i]) {
                break;
            }else {
                int tmp = a[parent];
                a[parent] = a[i];
                a[i] = tmp;
                parent = i;
            }
        }
    }
}
