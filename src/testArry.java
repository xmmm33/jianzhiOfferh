public class testArry<T extends Number> {
    private T[] arry;

    public T[] sortAcs() {
        int midIndex;
        for (int i = 0; i < arry.length - 1; i++) {
            midIndex = i;
            for (int j = i + 1; j < arry.length; j++) {

            }
        }
        return arry;
    }


    public static void main(String[] args) {
        Long[] a = {1200L, 52L, 5555L};
        testArry<Long> arry = new testArry<>();
        arry.sortAcs();

    }
}
