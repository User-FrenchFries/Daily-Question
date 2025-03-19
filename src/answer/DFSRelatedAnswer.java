package answer;

import question.DFSRelatedQuestion;

public final class DFSRelatedAnswer implements DFSRelatedQuestion {

    public static final DFSRelatedAnswer INSTANCE = new DFSRelatedAnswer();

    private DFSRelatedAnswer() {
        // empty
    }

    /**
     * 这里的思考方式为链式处理法。先分析下岛屿的关键组成，即必须为1.但当多个1相邻时，他们本质上为1个相同的岛屿
     * 因此，我们仅需要在遇到一个岛屿时，把该岛屿上所有相连的全部淹没掉，再进行下一个岛屿的寻找，完毕后，即最终的岛屿数量
     *
     * @param grid 待处理数组
     * @return 岛屿数量
     */
    @Override
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfsForIslands(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfsForIslands(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右相连的陆地
        dfsForIslands(grid, i + 1, j);
        dfsForIslands(grid, i, j + 1);
        dfsForIslands(grid, i - 1, j);
        dfsForIslands(grid, i, j - 1);
    }
}
