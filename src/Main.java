public class Main {
    private static final Answer answer = new Answer();

    public static void main(String[] args) {
        check1552();
    }

    private static void check1552() {
        int[] position = new int[]{5, 4, 3, 2, 1, 1000000000};
        int m = 2;
        int result = answer.getTheMaxDistance(position, m);
        System.out.printf("Max distance is : %d", result);
    }
}