package day1.time_0216_1814;

public class NonFobolaqi {

    public static void main(String[] args) {
        int index = 20;
        if (index == 0) {
            System.out.println(0);
        }
        if (index == 1) {
            System.out.println(1);
        }
        int ret = 0;
        int small = 0;
        int big = 1;
        for (int i = 0; i < index - 1; i++) {
            ret = small + big;
            small = big;
            big = ret;
        }
        System.out.println(ret);
    }
}
