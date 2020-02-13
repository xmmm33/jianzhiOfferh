package day1.time_0213_1322;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 奇数位丢弃
 */
public class Test2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i <= n; i++) {
            linkedList.add(i);
        }
        while (linkedList.size() > 1) {
            Iterator<Integer> it = linkedList.iterator();
            int i = 1;
            while (it.hasNext()) {
                int tmp = it.next();
                if (i % 2 == 1) {
                    it.remove();
                }
                i++;
            }
        }
        System.out.println(linkedList.get(0));
    }
}
