package answer;

import org.jetbrains.annotations.NotNull;
import question.SlidingWindowQuestion;

public class SlidingWindowAnswer implements SlidingWindowQuestion {
    public static final SlidingWindowAnswer INSTANCE = new SlidingWindowAnswer();

    private SlidingWindowAnswer() {
        // empty
    }

    @NotNull
    @Override
    /**
     * 暴力Split然后Sort去找，会超时
     */
    public int[] getSubarrayBeauty(@NotNull int[] nums, int k, int x) {
        int[] count = new int[101]; // [-50,50] → +50映射
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // 初始化窗口前k个
        for (int i = 0; i < k; i++) {
            count[nums[i] + 50]++;
        }
        ans[0] = getXSmall(count, x);

        for (int i = k; i < nums.length; i++) {
            count[nums[i] + 50]++;
            count[nums[i - k] + 50]--;
            ans[i - k + 1] = getXSmall(count, x);
        }
        return ans;
    }

    private int getXSmall(@NotNull int[] nums, int x) {
        int countX = 0;
        for (int i = 0; i < 50; i++) {
            countX += nums[i];
            if (countX >= x) return i - 50;
        }
        return 0;
    }
}
