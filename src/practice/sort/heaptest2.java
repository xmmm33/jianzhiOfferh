package practice.sort;

public class heaptest2 {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2312, 4124, 4, 23, 24, 24, 2, 5, 5, 4, 54, 2, 5, 325};
        build(a);
        sortheap(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sortheap(int[] a) {
        for (int i = a.length-1; i >0 ; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjust(a, 0, i);
        }
    }

    private static void build(int[] a) {
        if (a.length < 1) {
            return;
        }
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjust(a, i, a.length);
        }
    }

    private static void adjust(int[] a, int parent, int length) {
        int temp = a[parent];
        for (int i = 2*parent+1; i <length ; i = 2*i+1) {
            if (i + 1 < length && a[i] > a[i + 1]) {
                i++;
            }
            if (temp < a[i]) {
                break;
            }else {
                int tmp = a[i];
                a[i] = a[parent];
                a[parent] = tmp;
                parent = i;
            }
        }
    }


}
