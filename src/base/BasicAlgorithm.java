package base;

import java.util.List;

/**
 * 此类用于基础算法，即基本的排序等等
 */
public final class BasicAlgorithm {

    public static final BasicAlgorithm INSTANCE = new BasicAlgorithm();

    private BasicAlgorithm() {}

    /**
     * int mid = (low + high) / 2：
     * 这种方式直接将 low 和 high 相加，然后除以2来得到中间值。这种方法在处理较小的整数范围时通常是没有问题的，但是如果 low 和 high 非常大，相加的结果可能会导致整数溢出，从而得到错误的中间值。
     * 推荐在实现二分算法时使用第一种方式 int mid = low + (high - low) / 2，因为它更安全，能够避免整数溢出的问题，尤其是在处理大整数范围时。
     *
     * pos = {1, 2, 2, 6, 6, 6, 6, 8, 10}  target = 6
     * l = 3   u = 7  （这里指 index）
     *
     * @param pos    目标数组，前提条件是，当前数组已经是排好序的，且为递增
     * @param target 目标值
     * @return 返回，大于等于且最接近当前target的坐标值
     */
    public int lowerBound(List<Integer> pos, int target) {
        int low = 0, high = pos.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param pos    目标数组，前提条件是，当前数组已经是排好序的，且为递增
     * @param target 目标值
     * @return 返回大于当前目标值，且最近的下标
     */
    public int upperBound(List<Integer> pos, int target) {
        int low = 0, high = pos.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
