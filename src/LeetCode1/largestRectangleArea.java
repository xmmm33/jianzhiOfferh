package LeetCode1;

public class largestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        if (heights.length < 1) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int hight = heights[i];
            for (int j = i; j < heights.length; j++) {
                hight = Math.min(hight,heights[j]);
                int tempres = (j - i + 1) * hight;
                max = Math.max(tempres, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
