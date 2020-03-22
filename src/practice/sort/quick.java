package practice.sort;

public class quick {

    public static void quick(int[] array) {
        if (array.length < 1) {
            return;
        }
        quicksort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int base = array[low];
        // low和high不能变 所以需要两个辅助指针
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && array[right] >= base) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= base) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = base;
        // 左边界和右边界固定
        quicksort(array, low, left - 1);
        quicksort(array, right+1, high);
    }
    public static void main(String[] a) {
        int[] b = new int[]{1, 5, 6, 1, 32, 5, 4, 5, 1, 2, 54, 3, 131};
        qucik(b);
    }

    public static void qucik(int[] array) {
        if (array.length < 1) {
            return;
        }
        quciksort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void quciksort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int base = array[low];
        int leftpoint = low;
        int rightpoint = high;
        while (leftpoint < rightpoint) {
            while (leftpoint < rightpoint && array[rightpoint] >= base) {
                rightpoint--;
            }
            array[leftpoint] = array[rightpoint];
            while (leftpoint < rightpoint && array[leftpoint] <= base) {
                leftpoint++;
            }
            array[rightpoint] = array[leftpoint];
        }
        array[leftpoint] = base;
        quciksort(array, low, leftpoint - 1);
        quciksort(array, rightpoint + 1, high);
    }



}
