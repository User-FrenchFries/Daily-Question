package answer;

import question.DynamicProgrammingQuestion;

/**
 * 动态规划相关问题解决类
 */
public final class DynamicProgrammingAnswer implements DynamicProgrammingQuestion {
    static final int INF = 0x3f3f3f3f;

    public static final DynamicProgrammingAnswer INSTANCE = new DynamicProgrammingAnswer();

    private DynamicProgrammingAnswer() {
        // empty
    }

    /**
     * 对此进行简单分析，对于n块毯子，使得其最小，就是在 n-1 最小时，附加上最后一块盖最多的就可以了。
     * 但是，如何保证之前的是最小的呢？现在的最小和之前其实是会产生联系的
     * 101111 2 3 。其中的最优解为 0.也就是说我们选择的覆盖，对后续的覆盖是由影响的
     * 此处的dp，通过处理当前块是否要进行覆盖去进行思考处理
     * <p>
     * 动态方程：d[i][j]=min(d[i−1][j]+[第i个砖块是否为白色砖块],d[i−carpetLen][j−1])
     * 1. 在i处不放置地毯，由d[i−1][j]在加上i处是否为白色砖块得到
     * 2. 在i处放置地毯，由d[i−carpetLen][j−1]转移得到，i−carpetLen可能为负数，此时需要取0。(j代表使用的毯子个数，需要减去1，我们将此处当做最后毯子盖住的末尾来看待即可)
     * 其实经过这样的转移，就将所有的情况全部遍历的(二维数组其实存储了所有的情况了，但是转移方程可以让我们的计算量变少)
     *
     * @param floor      待处理地砖
     * @param numCarpets 地毯数量
     * @param carpetLen  地毯长度
     * @return 最小个数
     */
    @Override
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        // 初始创建好我们的dp维护组，最终答案为d[n][numCarpets]。
        // 此处的i针对当前块(即当前块在毯子下的最优解：盖或者不盖)，
        int n = floor.length();
        int[][] d = new int[n + 1][numCarpets + 1];
        // 初始化我们的数组，全部为最大值
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= numCarpets; j++) {
                d[i][j] = INF;
            }
        }
        // 令砖块的下标从1开始，那么，所有的都可以初始化为0，d[i][0]为前i个砖块中白色砖块的数量。
        for (int j = 0; j <= numCarpets; j++) {
            d[0][j] = 0;
        }
        // 没有毯子可盖，那么此值就是白块累加
        for (int i = 1; i <= n; i++) {
            d[i][0] = d[i - 1][0] + (floor.charAt(i - 1) == '1' ? 1 : 0);
        }
        // 根据此方程来添加即可。i，j都从1开始，其实相当于我们画了一张表格，最外围是毯子为0；无块时的情况
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= numCarpets; j++) {
                d[i][j] = d[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0);
                d[i][j] = Math.min(d[i][j], d[Math.max(0, i - carpetLen)][j - 1]);
            }
        }
        return d[n][numCarpets];
    }
}
