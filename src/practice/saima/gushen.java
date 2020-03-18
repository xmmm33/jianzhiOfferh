package practice.saima;

import java.util.Scanner;

public class gushen {


    public static void countVlaue(int n) {
        if (n <= 0)
            return;
        int ret = 0;
        int res = 0;
        int cnt = 1;
        int tem = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ret = i;
                res = res + ret;
                continue;
            }
            if (cnt > 0) {
                res = ret +1;
                cnt--;
            } else {
                res = ret -1;
                cnt = tem + 1;
                tem++;
            }
            ret = res;

        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        countVlaue(n);
    }
}
