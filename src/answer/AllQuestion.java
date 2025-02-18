package answer;

public interface AllQuestion {

    /**
     * 1552. 两球之间的磁力
     * @param m 放置的球个数
     * @param position 对应磁力值
     * @return 最大化最小磁力值
     */
    int getTheMaxDistance(int[] position, int m);

    /**
     * 1287. 有序数组中出现次数超过25%的元素
     * @param arr 目标数组
     * @return 遍历寻找到目标值即可
     */
    int findTarget25Num(int[] arr);
}
