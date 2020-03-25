package leetcode;

/**
 * 接雨水
 * 从当前坐标为中心，左边找到最高的，右边找到最高的
 * 然后Math.min(maxleft,maxright) - height[i]就是当前坐标能够接到的水
 */
public class trap {
    public int trap(int[] height) {
        int len = height.length;
        int max = 0;
        for(int i =1; i< len;i++){
            int maxleft = 0;
            int maxright = 0;
            for(int j=i;j>=0;j--){
                maxleft = Math.max(maxleft,height[j]);
            }
            for(int j=i;j<len;j++){
                maxright = Math.max(maxright,height[j]);
            }
            max = max + Math.min(maxleft,maxright) - height[i];
        }
        return max;
    }

}
