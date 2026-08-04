package question

/**
 * 滑动窗口相关问题
 */
interface SlidingWindowQuestion {

    /**
     * Middle
     * 2653. 滑动子数组的美丽值
     * 注意：原始nums值域在 -50 ~ 50
     */
    fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray
}