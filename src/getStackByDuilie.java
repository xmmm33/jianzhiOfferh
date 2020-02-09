import java.util.Stack;

/**
 * 用两个站来实现一个队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author MSI
 */
public class getStackByDuilie {

    /**
     * 第一个栈用来接收数据
     * 第二个栈用来输出数据
     */
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return Integer.parseInt(null);
        }

    }

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(pop());
    }
}
