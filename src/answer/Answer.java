package answer;

import question.BinarySearchQuestion;

public class Answer implements BinarySearchQuestion {
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
}
