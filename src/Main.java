import java.util.*;

/**
 * 笔试用
 * 邻接矩阵寻找环
 */
public class Main {


    static List<Integer> trace;

    static Set<Integer> searched = new HashSet<>();

    static Set<List<Integer>> allCircles = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] martx = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                martx[i][j] = sc.nextInt();
            }
        }
        int startNode = sc.nextInt();
        if (searched.contains(startNode)) {
            return;
        }
        trace = new ArrayList<>();
        findCycle(startNode, martx);
        for(List<Integer> list:allCircles){
            if (!list.get(0).equals(startNode)) {
                continue;
            }
            System.out.println("circle: "+list);
        }
    }

    private static void findCycle(int startNode, int[][] martx) {
        int j = trace.indexOf(startNode);
        if (j != -1) {
            List<Integer> circle = new ArrayList<>();
            while (j < trace.size()) {
                circle.add(trace.get(j));
                j++;
            }
            circle.add(startNode);
            allCircles.add(circle);
            return;
        }
        trace.add(startNode);
        for (int i = 0; i < martx.length; i++) {
            if (martx[startNode][i] == 1) {
                searched.add(i);
                findCycle(i, martx);
            }
        }
        trace.remove(trace.size() - 1);
    }
}
