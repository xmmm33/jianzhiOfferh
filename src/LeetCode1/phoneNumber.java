package LeetCode1;

import java.util.ArrayList;
import java.util.List;

public class phoneNumber {

    private static String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };


    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<String>();
        if(digits.equals(""))
            return res;
        dfs(digits, "",0,res);
        return res;
    }

    private static void dfs(String digits, String letter, int index, List<String> res) {
        if (index == digits.length()) {
            res.add(letter);
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0';
        String number = letterMap[pos];
        for (int i = 0; i < number.length(); i++) {
            dfs(digits,letter+number.charAt(i),index+1, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
