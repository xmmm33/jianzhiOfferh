package practice.sort;

/**
 * 归并排序 Onlogn  稳定
 */
public class guibing {

    public static void guibing(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        guibing(array, low, mid);
        guibing(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int left = low, k = low;
        int right = mid+1;
        // 辅助数组
        int[] temp = new int[array.length];
        while (left <= mid && right <= high) {
            if (array[left] < array[right]) {
                temp[k++] = array[left++];
            }else {
                temp[k++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = array[left++];
        }
        while (right <= high) {
            temp[k++] = array[right++];
        }
        for (int i = low; i <=high ; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] a) {
        int[] b = new int[]{1, 5, 6, 1, 32, 5, 4, 5, 1, 2, 54, 3, 131};
        sotr4(b, 0, b.length - 1);
        for (int i : b) {
            System.out.println(i);
        }
    }

    public static void guibingtwo(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        // 递归分区
        guibingtwo(array, low, mid);
        guibingtwo(array, mid + 1, high);
        // 排序合并
        mergetwo(array, low, mid, high);
    }

    private static void mergetwo(int[] array, int low, int mid, int high) {
        int left = low,k=low;
        int right = mid + 1;
        int[] temp = new int[array.length];
        while (left <= mid && right <= high) {
            if (array[left] > array[right]) {
                temp[k++] = array[right++];
            }else {
                temp[k++] = array[left++];
            }
        }
        while (left <= mid) {
            temp[k++] = array[left++];
        }
        while (right <= high) {
            temp[k++] = array[right++];
        }
        for (int i = low; i <=high ; i++) {
            array[i] = temp[i];
        }
    }


    public static void guibingss(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        guibingss(a, low, mid);
        guibingss(a, mid + 1, high);
        sortmy(a, low, mid, high);
    }

    private static void sortmy(int[] a, int low, int mid, int high) {
        int left = low;
        int k = low;
        int right = mid+1;
        int[] temp = new int[a.length];
        while (left <= mid && right <= high) {
            if (a[left] < a[right]) {
                temp[k++] = a[left++];
            }else {
                temp[k++] = a[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = a[left++];
        }
        while (right <= high) {
            temp[k++] = a[right++];
        }
        for (int i = low; i <=high ; i++) {
            a[i] = temp[i];
        }
    }


    public static void sotr4(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sotr4(a, low, mid);
        sotr4(a, mid + 1, high);
        sotr44(a, low, mid, high);
    }

    private static void sotr44(int[] a, int low, int mid, int high) {
        int left = low;
        int k = low;
        int right = mid+1;
        int[] temp = new int[a.length];
        while (left <= mid && right <= high) {
            if (a[left] < a[right]) {
                temp[k++] = a[left++];
            }else {
                temp[k++] = a[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = a[left++];
        }
        while (right <= high) {
            temp[k++] = a[right++];
        }
        for (int i = low; i <=high ; i++) {
            a[i] = temp[i];
        }
    }
}
