package questionBean;

/**
 * 1061. 按字典序排列最小的等效字符串
 * 获取两个字串间联通的内容，使用并查集完成元素的构建
 */
public class UnionFindMinStr {

    private final int[] parent;

    public UnionFindMinStr(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找元素x的根节点（带路径压缩）
     * 如果存储值和当前值相同，那么代表，当前则为目标值；否则，当前存储的是父节点的值，继续寻找
     * 对于最终的使用，外界也仅可以通过该方法完成目标值的寻找(并查集内部完成了元素间关系的搭建，通过递归寻找)
     */
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 路径压缩
        }
        return parent[x];
    }

    /**
     * 这里其实就是最终的维护逻辑，父节点的值代表的含义是什么，由此处的逻辑确定
     *
     * @param x 待处理值 x
     * @param y 待处理值 y
     */
    public void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        // 总是让字典序更小的作为集合代表字符
        parent[y] = x;
    }
}
