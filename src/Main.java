import answer.Answer;
import interview.string.LcsRelatedQuestion;
import interview.string.PalindromeRelatedQuestion;
import questionBean.BrowserHistory;
import questionBean.RangeFreqQuery;
import utils.PrintUtil;
import utils.SortUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Answer answer = new Answer();

    public static void main(String[] args) {
        checkQuestion1456();
    }

    private static void check1552() {
        int[] position = new int[]{5, 4, 3, 2, 1, 1000000000};
        int m = 2;
        int result = answer.getTheMaxDistance(position, m);
        System.out.printf("Max distance is : %d", result);
    }

    private static void check1287() {
        int[] numbs = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
        int result = answer.findTarget25Num(numbs);
        System.out.printf("The target num is : %d", result);
    }

    private static void check2080() {
        int[] source = new int[]{12, 33, 4, 56, 22, 4, 34, 33, 4, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(source);
        int result1 = rangeFreqQuery.query(1, 8, 4);
        System.out.printf("Query for [1, 2, 8] result is: %d", result1);
        System.out.println();
        int result2 = rangeFreqQuery.query(0, 11, 33);
        System.out.printf("Query for [0, 11, 33] result is: %d", result2);
    }

    private static void checkDispatchGoods() {
        int[] numbs = new int[]{11, 6};
        int result = answer.dispatchGoodsToStore(6, numbs);
        System.out.printf("The max dispatch goods is : %d", result);
    }

    private static void check2209() {
        int result = answer.minimumWhiteTiles("101111", 2, 3);
        System.out.printf("The min num white floor is : %d", result);
    }

    private static void check2506() {
        String[] words = new String[]{"aba", "aabb", "abcd", "bac", "aabc"};
        int result = answer.similarPairs(words);
        System.out.printf("The similar String num is : %d", result);
    }

    /**
     * 目标输出
     * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
     */
    private static void check1472() {
        List<String> result = new ArrayList<>();
        BrowserHistory history = new BrowserHistory("leetcode.com");
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        result.add(history.back(1));
        result.add(history.back(1));
        result.add(history.forward(1));
        history.visit("linkedin.com");
        result.add(history.forward(2));
        result.add(history.back(2));
        result.add(history.back(7));
        PrintUtil.INSTANCE.printListToString(result);
    }

    private static void check1328() {
        String palindrome = "abccba";
        String result = answer.breakPalindrome(palindrome);
        System.out.printf("The break palindrome String is : %s", result);
    }

    public static void testEightQueen() {
        List<List<String>> result = answer.solveEightQueens();
        System.out.printf("The final result count is : %d", result.size());
    }

    private static void check200() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = answer.numIslands(grid);
        System.out.printf("The count of island is : %d", result);
    }

    private static void check1061() {
        String s1 = "cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc";
        String s2 = "rjjlkbmnprkslilqmbnlasardrossiogrcboomrbcmgmglsrsj";
        String baseStr = "bxbwjlbdazfejdsaacsjgrlxqhiddwaeguxhqoupicyzfeupcn";
        String result = answer.smallestEquivalentString(s1, s2, baseStr);
        System.out.printf("The final result str is : %s", result);
    }

    private static void checkSortUtil() {
        int[] source = new int[]{1, 3, 2, 6, 5, 8, 11, 2};
        SortUtil.INSTANCE.quickSort(source);
        PrintUtil.INSTANCE.printListToString(PrintUtil.convertIntArrayToList(source));
    }

    private static void checkPalindromeUtil() {
        String source = "fwasdwafabbccbbaadwasdwa";
        PalindromeRelatedQuestion palindromeRelatedQuestion = new PalindromeRelatedQuestion();
        palindromeRelatedQuestion.longestPalindromeSubseq(source);
    }

    private static void checkLcsRelatedQuestion() {
        String text1 = "abcbc";
        String text2 = "bcb";
        LcsRelatedQuestion lcsRelatedQuestion = new LcsRelatedQuestion();
        String result = lcsRelatedQuestion.getLCS(text1, text2);
        System.out.printf("The final lcs str is : %s", result);
    }

    private static void checkQuestion1456() {
        String s = "abciiidef";
        int k = 3;
        int result = answer.maxVowels(s, k);
        System.out.printf("The max value of str is : %d", result);
    }
}