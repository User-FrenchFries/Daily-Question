package interview.string;

/**
 * Author: JohnZeng
 * Date: 2023/9/20 14:03
 * Description: 添加回文字符串相关的解法 --- 由其物理特性切入，加载对应解决方法
 * History:
 * <author> <time> <version> <desc>
 * JohnZeng 2023/9/20 1.0 首次创建
 */
public final class PalindromeRelatedQuestion {

    /**
     * 回文字符串的最大回文子序列
     *
     * @param s 目标字符串
     */
    public void longestPalindromeSubseq(String s) {
        if (s.length() < 2) {
            return;
        }
        LongestPalindromeOrigin longestPalindromeOrigin = new LongestPalindromeOrigin();
        String expand = longestPalindromeOrigin.LongestPalindrome(s);
        System.out.printf("The final Palindrome String found by expand is : %s, length = %d", expand, expand.length());
        System.out.println();
        String dp = longestPalindromeByDp(s);
        System.out.printf("The final Palindrome String found by dp sort is : %s, length = %d", dp, dp.length());
        System.out.println();
        String manacher = manacherAlgorithm(s);
        System.out.printf("The final Palindrome String found by manacher is : %s, length = %d", manacher, manacher.length());
    }


    private static class LongestPalindromeOrigin {
        int maxLength = 1;
        int start = 0;

        /**
         * 通用解法，中心拓展
         * <p>
         * 遍历每个字符，最长的情况，就在于当前为偶数长度和奇数长度是否符合回文要求
         * baab
         * bab
         */
        public String LongestPalindrome(String s) {
            if (s.length() < 2) {
                return s;
            }

            for (int i = 0; i < s.length(); i++) {
                expandAroundCenter(s, i, i);
                expandAroundCenter(s, i, i + 1);
            }

            return s.substring(start, start + maxLength);
        }

        private void expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len > maxLength) {
                maxLength = len;
                start = left + 1;
            }
        }
    }

    /**
     * 动态规划解法
     * <p>
     * 那么对于子问题的拆分，我们仍需要分奇偶进行判断
     * 我们先定义dp[i][j] = true 表示s[i..j]是回文串，那么所有的dp[i][i] 都为 true
     * 开始从子问题往上堆叠，
     * 如果当前s[i] == s[j],若当前子串长度<=2,那么dp[i][i] = true；否则dp[i][j] = dp[i+1][j-1]
     * 如果当前s[i] != s[j],那么dp[i][j] = false
     */
    private String longestPalindromeByDp(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int start = 0;

        // 这里的遍历，是从长度开始的，映射到Dp二维表上，其实就是对不同长度下的dp值进行填充
        for (int L = 2; L < s.length(); L++) {
            for (int i = 0; i <= s.length() - L; i++) {
                int j = i + L - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (L <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && L > maxLength) {
                    maxLength = L;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    /**
     * 马拉车算法
     * 对中心拓展方法的计算优化
     * 1. 统一问题为奇数情况处理
     * 2. 对已经计算过的回文半径，进行记录，避免重复计算 ---- 标记每个坐标值下的最大半径
     * 3. 从左往右遍历一次，即可获取到最终解
     *
     * @param s 目标字符串
     * @return 返回最大回文子序列的长度
     */
    public String manacherAlgorithm(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // 步骤1：预处理字符串，插入#
        String processed = preprocess(s);
        int n = processed.length();
        int[] radius = new int[n]; // 回文半径数组
        int center = 0; // 当前最长回文的中心
        int right = 0; // 当前最长回文的右边界
        int maxRadius = 0; // 最大回文半径
        int maxCenter = 0; // 最大回文的中心

        // 步骤2：遍历计算radius数组
        for (int i = 0; i < n; i++) {
            // 步骤3.1：利用对称性初始化radius[i]
            if (i < right) {
                int iMirror = 2 * center - i;
                radius[i] = Math.min(right - i, radius[iMirror]);
            } else {
                radius[i] = 1; // 初始半径为1（自身）
            }

            // 步骤3.2：尝试扩展
            while (i - radius[i] >= 0 && i + radius[i] < n
                    && processed.charAt(i - radius[i]) == processed.charAt(i + radius[i])) {
                radius[i]++;
            }

            // 步骤3.3：更新center和right
            if (i + radius[i] - 1 > right) {
                center = i;
                right = i + radius[i] - 1;
            }

            // 记录最大回文半径和中心
            if (radius[i] > maxRadius) {
                maxRadius = radius[i];
                maxCenter = i;
            }
        }

        // 步骤4：映射回原字符串
        int start = (maxCenter - maxRadius + 1) / 2; // 原字符串起始索引
        int length = maxRadius - 1; // 原字符串回文长度
        return s.substring(start, start + length);
    }

    // 预处理：在每个字符间插入#，首尾也插入#
    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        return sb.toString();
    }
}
