import java.util.Arrays;

public class Answer implements AllQuestion {

    /**
     * 寻找最大的最小磁力，那么必然存在一个目标临界值，使得小于此值的任意值，都满足要求；大于此值的任意值均不满足。
     * 此种情况下使用二分法处理
     * 需要注意的就是：
     * 1. 二分的起始和终止值
     * 2. 范围校验
     * 3. 结果的检测方法--即二分后的区间选择判断
     */
    @Override
    public int getTheMaxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (checkValue(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 检查当前值是否为合法值
     *
     * @param curValue 当前的最小磁力
     * @param position 磁力值数组
     * @param m        目标放置个数
     * @return 以当前最小磁力，算出当前可放置的最大个数，看是否可以放下目标个数
     */
    private boolean checkValue(int curValue, int[] position, int m) {
        int count = 1;
        int pre = position[0];
        for (int j : position) {
            if (j - pre >= curValue) {
                pre = j;
                count++;
            }
        }
        return count >= m;
    }
}
