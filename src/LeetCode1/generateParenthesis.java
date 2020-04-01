package LeetCode1;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成所有可能的括号
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class generateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String letter, int left,int right,List<String> res){
        if(left==0 && right == 0){
            res.add(letter);
            return;
        }
        // 剪枝 只能左括号先排完
        if (left > right) {
            return;
        }

        if(left > 0){
            dfs(letter + "(", left - 1, right, res);
        }
        if(right > 0){
            dfs(letter + ")", left, right - 1, res);
        }
    }
}
