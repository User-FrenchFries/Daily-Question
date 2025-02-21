package question;

/**
 * 动态规划相关处理的问题
 * 其实并没有我们想象的那么复杂，建立dp数组的表，其实本质上就是将所有情况完全遍历并放置到其表内存储
 * 本质上还是全遍历(非剪枝的情况下)。同时在遍历过程中，完成目标值的计算输出
 */
public interface DynamicProgrammingQuestion {

    /**
     * Hard
     * 2209. 用地毯覆盖后的最少白色砖块
     */
    int minimumWhiteTiles(String floor, int numCarpets, int carpetLen);
}
