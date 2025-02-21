package answer;

import question.BinarySearchQuestion;
import question.BitOperationQuestion;
import question.DynamicProgrammingQuestion;
import question.NormalQuestion;

import java.util.List;

public class Answer implements BinarySearchQuestion, NormalQuestion, BitOperationQuestion, DynamicProgrammingQuestion {
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
}
