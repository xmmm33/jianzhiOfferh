package LeetCode1.tanxin;


/**
 * 是否能种下n朵花
 */
public class canFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length < 1){
            return false;
        }
        if(flowerbed.length == 1 && flowerbed[0]==0 && n==1){
            return true;
        }
        for(int i = 1;i<flowerbed.length-1;i++) {
            if(n <= 0){
                return true;
            }
            if(i == 1 && flowerbed[i] == 0 && flowerbed[i-1] == 0){
                n--;
                flowerbed[i-1] = 1;
            }
            if(flowerbed[i-1] == 0 && flowerbed[i] == 0&& flowerbed[i+1] == 0){
                n--;
                flowerbed[i] = 1;
            }
            if(i+1 == flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                n--;
                flowerbed[i+1] = 1;
            }
        }
        if(n <= 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] arg) {
        canPlaceFlowers(new int[]{0,0,0,0,1}, 2);
    }
}
