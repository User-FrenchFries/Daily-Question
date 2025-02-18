package questionBean;

import base.BasicAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 2080. 区间内查询数字的频率
 * 对于原有的需求来说，我们直接遍历对应子区间寻找到匹配值也是可以的，但是由于数据量会导致超时
 * 因此，我们维护一个hashmap，其中包含对应值的所有坐标list
 * 在寻找当前匹配值时，获取此值对应的list；从其中，寻找到落在[left，right]区间内的坐标，并计数返回。
 * 对于list中的坐标寻找，这里可以使用二分查找，使用lowerBound和upBound寻找到其对应的边界，由此来
 */
public class RangeFreqQuery {
    private final Map<Integer, ArrayList<Integer>> source = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            source.putIfAbsent(arr[i], new ArrayList<>());
            source.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        int count = 0;
        if (source.containsKey(value)) {
            ArrayList<Integer> list = source.get(value);
            int leftIndex = BasicAlgorithm.INSTANCE.lowerBound(list, left);
            int rightIndex = BasicAlgorithm.INSTANCE.upperBound(list, right);
            return rightIndex - leftIndex;
        }
        return count;
    }
}
