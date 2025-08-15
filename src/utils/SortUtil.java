package utils;

public final class SortUtil {
    public static final SortUtil INSTANCE = new SortUtil();

    private SortUtil() {
        // empty
    }

    public void quickSort(int[] source) {
        quickSort(source, 0, source.length - 1);
    }

    private void quickSort(int[] source, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = source[left];
        int i = left;
        int j = right;
        // 根据当前基准值，进行范围内排序
        while (i < j) {
            // 从右往左找
            while (i < j && source[j] >= pivot) {
                j--;
            }
            // 从左往右找
            while (i < j && source[i] <= pivot) {
                i++;
            }
            // 交换
            if (i < j) {
                int temp = source[i];
                source[i] = source[j];
                source[j] = temp;
            }
        }
        // 整理完毕，将基准值填入到对应为止。i的最终位置<=pivot,因此交换一次就好
        source[left] = source[i];
        source[i] = pivot;
        // 递归左边
        quickSort(source, left, i - 1);
        // 递归右边
        quickSort(source, i + 1, right);
    }
}
