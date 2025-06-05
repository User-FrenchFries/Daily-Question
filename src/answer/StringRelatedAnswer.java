package answer;

import question.StringRelatedQuestion;
import questionBean.UnionFindMinStr;
import utils.StringUtil;

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

    /**
     * 处理后需要不再为回文串，且字典序列最小(aba < abb) --> 即第一个处理掉后使其不为回文串，且当前的坐标最小
     * 那么，我们需要拿 a 去替换掉第一个非 a 的字符即可。若无法替换，则修改最后一个字符为 b
     * 全为 a 的特殊情况，我们仅需要将中间的的字符替换为 b 即可完成需求
     *
     * @param palindrome 待处理的回文串
     * @return 处理后的内容
     */
    @Override
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() > 1) {
            // replaceAll 不会破坏传递的原始字符串，可以不用拷贝新的字符串去处理
            // 一般对于字串，不直接进行操作，而是转为charArray进行处理
            if (palindrome.replaceAll("a", "").isEmpty()) {
                return StringUtil.INSTANCE.replaceCharAtIndex(palindrome, palindrome.length() / 2, 'b');
            } else {
                for (int i = 0; i < palindrome.length() / 2; i++) {
                    if (palindrome.charAt(i) != 'a') {
                        return palindrome.replaceFirst(String.valueOf(palindrome.charAt(i)), "a");
                    }
                }
                // aba --> abb;直接替换b，又会使得其变为回文串
                return StringUtil.INSTANCE.replaceCharAtIndex(palindrome, palindrome.length() - 1, 'b');
            }
        } else {
            return "";
        }
    }

    @Override
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFindMinStr uf = new UnionFindMinStr(26);
        for (int i = 0; i < s1.length(); i++) {
            uf.unite(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) ('a' + uf.find(c - 'a')));
        }
        return sb.toString();
    }
}
