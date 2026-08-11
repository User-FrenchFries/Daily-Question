package question;

import java.util.List;

/**
 * 通常的问题
 */
public interface NormalQuestion {
    /**
     * Easy
     * 624. 数组列表中的最大距离
     */
    int getMaxDistanceInArray(List<List<Integer>> arrays);

    /**
     * 获取top K大的数
     *
     * @param arrays
     * @return
     */
    List<Integer> topKMaxInArray(List<Integer> arrays, int k);
}
