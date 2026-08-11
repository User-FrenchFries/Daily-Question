package answer;

import question.NormalQuestion;

import java.util.List;
import java.util.PriorityQueue;

public final class NormalAnswer implements NormalQuestion {

    public static final NormalAnswer INSTANCE = new NormalAnswer();

    private NormalAnswer() {
        // empty
    }

    /**
     * 一次遍历，由于会出现最大和最小值存在同一个数组的情况，我们维护两个变量值，并在遍历时，使用遍历得到的最大最小去计算和更新，保证两者之间不做计算
     * 就可以避免误算的情况，一次遍历后，结果即为正确内容
     *
     * @param arrays 待处理数组
     * @return 最大距离值
     */
    @Override
    public int getMaxDistanceInArray(List<List<Integer>> arrays) {
        int preMin = arrays.get(0).get(0);
        int preMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curList = arrays.get(i);
            int length = curList.size();
            int max1 = Math.abs(curList.get(length - 1) - preMin);
            int max2 = Math.abs(preMax - curList.get(0));
            ans = Math.max(ans, Math.max(max1, max2));
            preMin = Math.min(preMin, curList.get(0));
            preMax = Math.max(preMax, curList.get(length - 1));
        }
        return ans;
    }

    @Override
    public List<Integer> topKMaxInArray(List<Integer> arrays, int k) {
        // 升序为小顶堆，及最小值在顶部
        // b-a为降序，大的在前，故为大顶堆
        PriorityQueue<Integer> targetQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arrays) {
            if (targetQueue.size() < k) {
                targetQueue.add(i);
            } else {
                if (i < targetQueue.peek()) {
                    targetQueue.poll();
                    targetQueue.add(i);
                }
            }
        }
        return targetQueue.stream().toList();
    }
}
