/**
 * 笔试用
 */
public class Main2 {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);
    }
}
