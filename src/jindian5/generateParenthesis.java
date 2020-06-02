package jindian5;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {


    private List<String> res = new ArrayList<>();
    // 生成n对括号所能组成的所有集合
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        backtrace("", n, n);
        return res;
    }

    private void backtrace(String kuohao, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(kuohao);
            return;
        }
        // 必须左括号先比有括号使用完 剪枝的作用
        if (left > right) {
            return;
        }
        if (left > 0) {
            backtrace(kuohao + "(", left - 1, right);
        }
        if (right > 0) {
            backtrace(kuohao + ")", left, right - 1);
        }
    }


    // 练习 错误的，不能使用StringBuilder 只能使用String来做，因为这是引用类型变量
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        backtracetest(new StringBuilder(), n, n);
        return ans;
    }

    private void backtracetest(StringBuilder kuohao, int leftkuohaoshengyu, int rightkuohaoshengyu) {
        if (leftkuohaoshengyu > rightkuohaoshengyu) {
            return;
        }
        if (leftkuohaoshengyu == 0 && rightkuohaoshengyu == 0) {
            ans.add(new String(kuohao));
            return;
        }
        if (leftkuohaoshengyu > 0) {
            backtracetest(kuohao.append("("), leftkuohaoshengyu - 1, rightkuohaoshengyu);
        }
        if (rightkuohaoshengyu > 0) {
            backtracetest(kuohao.append(")"), leftkuohaoshengyu, rightkuohaoshengyu - 1);
        }
    }

}
