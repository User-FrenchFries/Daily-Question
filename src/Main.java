import answer.Answer;
import questionBean.RangeFreqQuery;

public class Main {
    private static final Answer answer = new Answer();

    public static void main(String[] args) {
        check2080();
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
}