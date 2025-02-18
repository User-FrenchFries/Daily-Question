import java.util.Arrays;

public class Answer implements AllQuestion {

    BasicAlgorithm basicAlgorithm = new BasicAlgorithm();

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

    /**
     * 对于题目中的特殊值，25%，我们可以使用二分去进行搜索，即[0~25],[25~50],[50~75],[75~100]四个部分
     * 当然，还可以使用hashTable、滑动窗口去判别
     *
     * @param arr 目标数组
     * @return 对应目标数值
     */
    @Override
    public int findTarget25Num(int[] arr) {
        int span = arr.length / 4 + 1;
        for (int i = 0; i < arr.length; i += span) {
            int start = binarySearchClosestIndex(arr, arr[i]);
            int end = binarySearchClosestIndex(arr, arr[i] + 1);
            if (end - start >= span) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 二分查找当前数组中最接近目标值的下标
     *
     * @param arr    目标数组
     * @param target 目标值
     * @return 对应值下标
     */
    private int binarySearchClosestIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}
