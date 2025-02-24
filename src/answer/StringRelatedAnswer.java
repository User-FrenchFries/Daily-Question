package answer;

import question.StringRelatedQuestion;

import java.util.HashMap;
import java.util.Map;

public final class StringRelatedAnswer implements StringRelatedQuestion {

    public static final StringRelatedAnswer INSTANCE = new StringRelatedAnswer();

    private StringRelatedAnswer() {
        // empty
    }

    /**
     * 提示信息：words[i] 仅由小写英文字母组成
     * <p>
     * 对于此，words中单个字符串最多包含26个不同的字符，我们将26位上的每一位都表示其是否存在，存在则为1
     * 那么我们仅需将单个字串中的每个字符，挨个遍历，并何其进行与操作，即可得到对应位为1或0
     * 最终将其匹配的状态，存储到Map中，并进行最终的累加，即可得到最终的结果值
     *
     * @param words 待处理的字符数组
     * @return 相似个数
     */
    @Override
    public int similarPairs(String[] words) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (String word : words) {
            int state = 0;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                state |= 1 << (c - 'a');
            }
            res += cnt.getOrDefault(state, 0);
            cnt.put(state, cnt.getOrDefault(state, 0) + 1);
        }
        return res;
    }
}
