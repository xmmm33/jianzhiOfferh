package practice.sort;

public class qiciktest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 1, 8, 15, 3, 1, 54, 65, 89454, 321, 54, 564};
        qucik(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void qucik(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int base = array[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && base <= array[right]) {
                right--;
            }
            array[left]  =  array[right];
            while (left < right && base >= array[left]) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = base;
        qucik(array, low, left - 1);
        qucik(array, right + 1, high);
    }
}
