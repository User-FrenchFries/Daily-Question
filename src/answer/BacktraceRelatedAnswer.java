package answer;

import question.BacktraceRelatedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BacktraceRelatedAnswer implements BacktraceRelatedQuestion {
    public static final BacktraceRelatedAnswer INSTANCE = new BacktraceRelatedAnswer();

    private BacktraceRelatedAnswer() {
        // empty
    }


    private List<List<String>> solutions = new ArrayList<List<String>>();

    /**
     * 对于此问题，更类似于选择问题，当前项被选择后，再无法进入到下一次的选择中，我们需要通过排列组合，完成最终可行解的组装(当前已选择，则不进入下一次的备选项中)
     *
     * @return 可行解列表
     */
    @Override
    public List<List<String>> solveEightQueens() {
        int maxQueen = 8;
        int[] queens = new int[maxQueen];

        backTraceQueen(queens, 0, maxQueen);

        return solutions;
    }

    /**
     * 可以看到，这里的方法仍然采用的是回溯处理，但是，我们可以发现，此处的回溯并未清除掉上次的选择，数组中残留的上次选择肯定会对判断造成影响
     * 但是，在检验方法中，他并不去看超出当前index的赋值项，这样的话，就完全排除掉了冗余内容的干扰
     *
     * @param queens        存储选择的数组
     * @param curQueenIndex 当前放置Queen下标
     * @param maxQueen      问题最大处理Queen个数
     */
    private void backTraceQueen(int[] queens, int curQueenIndex, int maxQueen) {
        if (curQueenIndex == maxQueen) {
            // 当前填充已到最大值，程序能运行到此处，代表已经填充的全部合法，这是一个可行解
            solutions.add(generateBoard(queens, maxQueen));
        } else {
            // 对于每一个 curQueenIndex 的Queen来说，他们同样有八个选择(即当前行的8个列，我们需要遍历得到每个列是否合法)
            for (int i = 0; i < maxQueen; i++) {
                queens[curQueenIndex] = i;
                // 尝试将当前列放置后，进行队列校验
                if (checkEnable(queens, curQueenIndex)) {
                    // 当前Queen位置合法，尝试填充下一个值
                    backTraceQueen(queens, curQueenIndex + 1, maxQueen);
                }
            }
        }
    }

    /**
     * 校验当前index填充时的Queen，位置是否合法，当前位置合法，才可以进行到下一个Queen的填充
     *
     * @param queens        已填的列表
     * @param curQueenIndex 当前处理下标
     * @return 校验结果，true 为合法值
     */
    private boolean checkEnable(int[] queens, int curQueenIndex) {
        for (int i = 0; i < curQueenIndex; i++) {
            if (queens[i] == queens[curQueenIndex] || Math.abs(queens[i] - queens[curQueenIndex]) == curQueenIndex - i) {
                return false;
            }
        }
        return true;
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
