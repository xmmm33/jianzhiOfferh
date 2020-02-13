package day1.time_0213_1322;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数
 */
public class GetUglyNumber_Solution {

    /**
     * 穷举法
     * 思路:2 3 5是丑数，那么2*2也是丑数 3*3也是丑数 5*5也是丑数，
     *     那么就维护三个队列指针，来指向235倍数的丑数，
     *     每次取235队列中最小的那个丑数
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int[] res = new int[index];
        // 指向2 、 3 、5的队列
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        res[0] = 1;
        for (int i = 1; i < index ; i++) {
            res[i] = Math.min(Math.min(res[p2]*2, res[p3]*3),res[p5]*5);
            if(res[i] == res[p2] * 2) p2++;
            if(res[i] == res[p3] * 3) p3++;
            if(res[i] == res[p5] * 5) p5++;
        }
        return res[index - 1];
    }
}
