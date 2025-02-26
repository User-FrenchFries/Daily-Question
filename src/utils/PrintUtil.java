package utils;

import java.util.List;

public final class PrintUtil {
    public static final PrintUtil INSTANCE = new PrintUtil();

    private PrintUtil() {
        // empty
    }

    public <E> void printListToString(List<E> source) {
        System.out.println("[");
        for (E item : source) {
            System.out.print(item.toString() + ", ");
        }
        System.out.print("]");
    }
}
