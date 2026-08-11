package question;

/**
 * 字符串及其数组相关对应问题
 */
public interface StringRelatedQuestion {
    /**
     * 2506. 统计相似字符串对的数目
     */
    int similarPairs(String[] words);

    /**
     * Middle
     * 1328. 破坏回文串
     * @param palindrome 待处理回文串
     * @return 处理后字段
     */
    String breakPalindrome(String palindrome);

    /**
     * Middle
     * 1061. 按字典序排列最小的等效字符串
     * @param s1 待匹配字符串1
     * @param s2 待匹配字符串2
     * @param baseStr 需要替换字符串
     */
    String smallestEquivalentString(String s1, String s2, String baseStr);
}
