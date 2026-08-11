package interview.string;

/**
 * Author: JohnZeng
 * Date: 2023/9/20 14:03
 * Description: 添加最长公共子序列相关的解法 --- 动态规划，标准解法(需要明白一点的是，这里的公共最长无需连续)
 * 应用场景：
 * 1. 字符串匹配
 * 2. 字符串比较
 * 3. 版本控制
 * 4. 文本差异分析
 * 5. 生物信息学
 * 6. 数据压缩
 * 7. 语音识别
 * 8. 自然语言处理
 * 9. 游戏开发
 * 10. 密码学
 * History:
 * <author> <time> <version> <desc>
 * JohnZeng 2023/9/20 1.0 首次创建
 */
public final class LcsRelatedQuestion {
    /**
     * 最长公共子序列
     *
     * @param s1 目标字符串1
     * @param s2 目标字符串2
     *           对于dp[i][j]，如果s1[i-1] == s2[j-1]，那么dp[i][j] = dp[i-1][j-1] + 1
     *           否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1])  保证连续的话，那么dp[i][j] = 0(没必要保持为dp[i-1][j-1]，无意义)
     *           这里的dp[i][j]表示s1的前i个字符和s2的前j个字符的最长公共子序列的长度
     * @return 返回最大公共子序列的长度
     */
    public int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 非连续要求
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    // 连续要求
                    // dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }

    // 扩展：获取LCS的具体字符串（需回溯DP表）
    public String getLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 先计算DP表（同上）
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 回溯DP表，构建LCS字符串
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                // 字符相同，加入LCS，同时向左上方移动
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // 上侧值更大，向上移动
                i--;
            } else {
                // 左侧值更大，向左移动
                j--;
            }
        }

        // 回溯得到的是逆序，需反转
        return sb.reverse().toString();
    }


    // 一维dp，理论原因在于，我们计算的关键仅在于dp[i-1][j-1]的值，那么本地存储并动态更新即可
    public int longestCommonSubstringOptimized(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        // 确保用较短的字符串长度作为数组长度
        if (m < n) {
            return longestCommonSubstringOptimized(text2, text1);
        }

        int maxLength = 0;
        int[] dp = new int[n + 1]; // 一维数组，存储上一行的状态

        for (int i = 1; i <= m; i++) {
            int prev = 0; // 保存dp[i-1][j-1]的旧值（上一行的前一列）
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // 暂存当前dp[j]（即上一行的j列）
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    // 非连续
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                    // 连续
                    // dp[j] = 0;
                }
                prev = temp; // 更新prev为下一轮的dp[i-1][j-1]
            }
        }

        return maxLength;
    }
}
