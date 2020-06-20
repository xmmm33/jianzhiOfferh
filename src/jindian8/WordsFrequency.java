package jindian8;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {


    /**
     * 你的实现应该支持如下操作：
     * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
     * get(word)查询指定单词在书中出现的频率
     * 示例：
     * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
     * wordsFrequency.get("you"); //返回0，"you"没有出现过
     * wordsFrequency.get("have"); //返回2，"have"出现2次
     * wordsFrequency.get("an"); //返回1
     * wordsFrequency.get("apple"); //返回1
     * wordsFrequency.get("pen"); //返回1
     */


    private Map<String, Integer> count = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String word : book) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return count.get(word) == null ? 0 : count.get(word);
    }
}
