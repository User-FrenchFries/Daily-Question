package answer;

import org.jetbrains.annotations.NotNull;
import question.*;

import java.util.List;

public class Answer implements BinarySearchQuestion,
        NormalQuestion,
        BitOperationQuestion,
        DynamicProgrammingQuestion,
        StringRelatedQuestion,
        BacktraceRelatedQuestion,
        DFSRelatedQuestion,
        SlidingWindowQuestion {
    /****************************  Binary Search ***************************************/
    @Override
    public int getTheMaxDistance(int[] position, int m) {
        return BinarySearchAnswer.INSTANCE.getTheMaxDistance(position, m);
    }

    @Override
    public int findTarget25Num(int[] arr) {
        return BinarySearchAnswer.INSTANCE.findTarget25Num(arr);
    }

    @Override
    public int dispatchGoodsToStore(int n, int[] quantities) {
        return BinarySearchAnswer.INSTANCE.dispatchGoodsToStore(n, quantities);
    }

    /****************************  Dynamic Programming ************************************/
    @Override
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        return DynamicProgrammingAnswer.INSTANCE.minimumWhiteTiles(floor, numCarpets, carpetLen);
    }

    /****************************  Normal ************************************/
    @Override
    public int getMaxDistanceInArray(List<List<Integer>> arrays) {
        return NormalAnswer.INSTANCE.getMaxDistanceInArray(arrays);
    }

    /****************************  Bit Operation ************************************/
    @Override
    public int[] evenOddBit(int n) {
        return BitOperationAnswer.INSTANCE.evenOddBit(n);
    }

    /****************************  String Related ************************************/
    @Override
    public int similarPairs(String[] words) {
        return StringRelatedAnswer.INSTANCE.similarPairs(words);
    }

    @Override
    public String breakPalindrome(String palindrome) {
        return StringRelatedAnswer.INSTANCE.breakPalindrome(palindrome);
    }

    @Override
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        return StringRelatedAnswer.INSTANCE.smallestEquivalentString(s1, s2, baseStr);
    }

    /****************************  BackTrace/DFS Related ************************************/
    @Override
    public List<List<String>> solveEightQueens() {
        return BacktraceRelatedAnswer.INSTANCE.solveEightQueens();
    }

    /****************************  DFS Related ************************************/
    @Override
    public int numIslands(char[][] grid) {
        return DFSRelatedAnswer.INSTANCE.numIslands(grid);
    }

    /****************************  Sliding Window Related ************************************/
    @NotNull
    @Override
    public int[] getSubarrayBeauty(@NotNull int[] nums, int k, int x) {
        return SlidingWindowAnswer.INSTANCE.getSubarrayBeauty(nums, k, x);
    }
}
