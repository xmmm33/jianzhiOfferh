package jindian;

import java.util.Arrays;

public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        char[] temps1 = s1.toCharArray();
        char[] temps2 = s2.toCharArray();
        Arrays.sort(temps1);
        Arrays.sort(temps2);
        if (String.valueOf(temps1).equals(String.valueOf(temps2))) {
            return true;
        }else {
            return false;
        }
    }
}
