package answer;

import question.BitOperationQuestion;

public final class BitOperationAnswer implements BitOperationQuestion {

    public static final BitOperationAnswer INSTANCE = new BitOperationAnswer();

    private BitOperationAnswer() {
        // empty
    }

    /**
     * 用i=0表示当前位是奇数位，i=1表示当前位是偶数位，并记录对应奇偶数位的结果。
     * 当n>0时，如果当前位是1，则增加对应奇偶位的计数，然后反转i并将n作右移位运算。
     * 循环以上过程，直到n=0，最后返回结果。
     *
     * @param n 待处理数据
     * @return 对应处理结果数组
     */
    @Override
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }

    /**
     * 通常的处理方法，一次遍历
     *
     * @param n 待处理数据
     * @return 对应处理结果数组
     */
    private int[] evenOddBitNormal(int n) {
        int[] result = new int[2];
        String trans = Integer.toBinaryString(n);
        for (int i = 0; i < trans.length(); i++) {
            if (trans.charAt(i) == '1') {
                if ((trans.length() - 1 - i) % 2 == 0) {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
        }
        return result;
    }
}
