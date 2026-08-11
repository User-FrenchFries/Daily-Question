package utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public final class PrintUtil {
    public static final PrintUtil INSTANCE = new PrintUtil();

    private PrintUtil() {
        // empty
    }

    // 泛型方法：将List集合转换为字符串并打印
    public <E> void printListToString(List<E> source) {
        // 处理null情况
        if (source == null) {
            System.out.println("List为null");
            return;
        }

        // 处理空集合情况
        if (source.isEmpty()) {
            System.out.println("[]");
            return;
        }

        // 使用StringBuilder拼接元素
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        // 使用迭代器遍历集合（支持所有List实现类）
        Iterator<E> iterator = source.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            // 非最后一个元素添加分隔符
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        System.out.println(sb);
    }

    public <E> void printArrayToString(E[] source) {
        // 处理空数组情况
        if (source == null) {
            System.out.println("数组为null");
            return;
        }

        // 使用StringBuilder拼接数组元素
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < source.length; i++) {
            // 添加元素
            sb.append(source[i]);
            // 除了最后一个元素，后面加逗号和空格
            if (i != source.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    public static List<Integer> convertIntArrayToList (int[] intArray) {
        // 处理 null 情况，避免 Stream 操作时出现 NullPointerException
        if (intArray == null) {
            return List.of (); // 返回不可变空列表
        }
        // 转换步骤：
        // 1. Arrays.stream (intArray) 将 int [] 转换为 IntStream
        // 2. boxed () 将 IntStream 中的 int 装箱为 Integer，转换为 Stream<Integer>
        // 3. collect (Collectors.toList ()) 将流收集为 List<Integer>
        return Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList());
    }
}
