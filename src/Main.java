public class Main {
    private static final Answer answer = new Answer();

    public static void main(String[] args) {
        check1287();
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
}