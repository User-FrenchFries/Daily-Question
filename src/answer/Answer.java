package answer;

import question.BinarySearchQuestion;
import question.BitOperationQuestion;
import question.NormalQuestion;

import java.util.List;

public class Answer implements BinarySearchQuestion, NormalQuestion, BitOperationQuestion {
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
}
